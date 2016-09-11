# KIV/PIA - JPA Association and Inheritance Mapping, Queries

This is project with resolved tasks from the JPA Basics Lab. See the jpa-basics module for blank lab project.

This lab covers:
 
* mapping of entity classes to database tables - associations and inheritance
* JPQL
* Criteria API

### Entity Mapping

In this section we continue with entity mapping we started during the last lab.
                  
#### Association Mapping

JPA supports mapping depending on the type of association between two entities, each represented by own association. 
Each of the annotations is used on *getter* of the respective property:

* ```@OneToMany``` used on collection-type attributes, representing 1..N association.
* ```@ManyToMany``` used on collection-type attributes, representing M..N association, creates extra table in the process
                    to maintain the database model in 3NF.
* ```@ManyToOne``` used on an entity attribute type, representing N..1 association.
* ```@OneToOne``` used on an entity attribute type, representing 1..1 association.
* ```@Embedded``` used when the associated entity's value should be stored in the same table as the owner entity.
                  This an alternative to ```@OneToOne``` mapping, preference depends on the particular usecase.
                  Entities which are associated via ```@Embedded``` must be annotated with ```@Embeddable``` annotation
                  instead of ```@Entity```. Such entities dont have own primary key.

Just like entity and basic attributes have their ```@Table``` and ```@Column``` annotations, the association mappings
can be complemented by ```@JoinTable``` for the many-to-many relationship and ```@JoinColumn``` for the rest.

When mapping associations, it is important to understand the concept of **LAZY** loading. By default all collection mapping
are loaded only when they are actually used. I.e. until you access the attribute, it is filled with a proxy object capable
of loading the data when needed. The idea behind this is that in many cases you don't require all the associations loaded 
e.g. (when listing all users in the system, you don't need to read all the Notes they have).

Decision which associations to load eagerly (together with the main object) and which lazily (on access) is crucial to
proper optimization of your application. To load an association, by default, another DB query must be run. 
If done badly, use of JPA may result in hundreds of database queries run to load a single page (that is bad ;) ).

It is a good assumption that all collections should be always lazily loaded and extra DAO method used to retrieve the list when needed.
At the same time I would claim that from my experience it is **in many cases** wise to lazily load all associations and
use **JOIN FETCH** (see the JPQL section later) instead. We will cover proper query optimization in a single lab.

#### Inheritance Mapping

There are two main approaches to inheritance mapping:

1. If the parent class is not a stand-alone entity, yet only set of common fields, it should be declared
as ```@MappedSuperclass```. Such class is not managed as an entity, doesn't have own table. Serves only
as a shared definition of field mappings.
1. If the parent class is an entity on its own, it is marked with ```@Entity``` as usual, plus specific
mapping strategy can be chosen using ```@Inheritance``` annotation on the parent entity class:
    * **JOINED** - parent entity fields are mapped in the parent table, the subclass fields are mapped in the
                  subclass table. Retrieval of the full subclass instance requires JOIN between the tables.
    * **TABLE_PER_CLASS** - each entity has own table, where all the attributes are stored. No JOINs required.
                            List of all instances of the parent class requires multiple queries, though.
    * **SINGLE_TABLE** - there is only one table per class hierarchy. Certain columns are null depending
                          on the particular subclass. Concrete class decided using *discriminator value*.
                          
Concrete strategy depends on the particular use-case - **single table** strategy makes it very easy to 
 retrieve all instance of the hierarchy, but may produce very large tables. **table per class** removes
 the inheritance from the persistance level, but makes it more difficult to query over multiple classes
 in the same hierarchy (multiple queries required). Etc.
                 
## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.