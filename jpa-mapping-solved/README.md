# KIV/PIA - JPA Mapping Solved

This is project with resolved tasks from the JPA Basics Lab. See the jpa-basics module for blank lab project.

This lab covers:
 
* basic set-up of JPA persistence context backed by Hibernate provider;
* elementary mapping of entity classes to database tables
* association mapping, inheritance mapping
* JPQL
* Criteria API

## Java Persistence Query Language

JPQL is SQL-like language independent on the underlying JPA implementation or datastore. It is very similar to SQL, see
[full specification](http://docs.oracle.com/html/E13946_04/ejb3_langref.html) for details.

The language uses entities and their attributes to form queries in the same way SQL uses tables and columns. 
The following query would return list of users with the given username.

        SELECT u FROM User u WHERE u.username=:username
        
where ```:username``` is a named parameter with name ```username``` (without the ```:```).

JPQL supports SELECT queries and also bulk UPDATE and DELETE queries. Single UPDATE and DELETE and also INSERT
operations should be performed using entity manager.

### Joins

Joining in JPQL queries follows entity relationships instead of data tables. Check the [nice overview](http://www.objectdb.com/java/jpa/query/jpql/from).
 
## JPA Criteria API
 
 Criteria API is mechanism for building dynamic, type-based queries in a programmatic way (instead of using
 the SQL-like JPQL. Their expressive power is equal, hence it is up to the user which one he prefers.
 
 Typed criteria queries are suitable for dynamic cases and allow earlier detection of errors. On
 the other hand, the string-based JPQL might be easier to read and understand due to its similarity to SQL.
 
 Nice overview of Criteria API basics can be found in the [ObjectDB documentation](http://www.objectdb.com/java/jpa/query/criteria).
 
### JPA Metamodel Generator

JPA Metamodel is a representation of your application's entity graph. The metamodel contains
representation of all managed entity classes and their attributes, making them available for use
in Criteria API queries instead of string paths. This allows, unlike string paths, for static
type check and earlier error detection.

The metamodel can be generated automatically. See ```pom.xml``` of this project and 
[JBoss Documentation](http://docs.jboss.org/hibernate/orm/4.3/topical/html/metamodelgen/MetamodelGenerator.html)
for details.

To generate the metamodel run the following:

        mvn processor:process
        
Check that the ```target``` folder now contains class representations with the following name
structure: ```<EntityName>_```.
                  
## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.