WebService Lab
==========

Lab for WebService client and server demonstration.


This example has been created for a Internet Application Programming (KIV/PIA) labs at the Department of Computer Science,
University of West Bohemia in Pilsen, Czech Republic.

## WebServices

* Check core.posts.dao.jaxrs package for client-side implementation.
* Check webapp.service package for server-side implementation

### WS API

Mock service and WS API description is located at [Apiary.io](http://docs.springlab.apiary.io/)

Apiary.io is a tool for web service API specification using Markdown syntax. Except for pretty documentation,
you get a mock server responding with provided examples and client code generator in various programming languages.

Your API blueprint can be automatically linked to the project repository at GitHub.

### Tasks

1. Run the application and check [main page](http://localhost:8080/).

#### Client-side

First we finish the client-side of our application. The PostDaoJAXRS is not providing us with comments, we need to fix that.

1. Initially we need to define class which will represent the data we receive from the web-service. Take a look at the 
examples of **post** resource in the [documentation](https://springlab.docs.apiary.io/#reference/posts/posts-collection/list-all-posts).
1. Now take a look at the clas *dao.jaxrs.PostDTO*. See the attribute names and keys in **@JsonProperty** annotations? How
are they connected to the documentation from the previous step?
1. Now take a look at the [documentation of **comments** resource](https://springlab.docs.apiary.io/#reference/posts/comments-collection/list-all-comments)
and modify *dao.jaxrs.CommentDTO* class accordingly.

Now we have prepared data model for consuming **comments** from the web service.

1. Take a look into the implementation of the ```findAllPosts``` method. The ```findAllComments``` will look very similar,
the only differences will be **path** pointing to the *comments* resource and the fact that we will be working with 
**CommentDTO** class and **Comment** entity instead of **PostDTO** and **Post**.
1. Implement the ```findAllComments``` method in the same fashion the ```findAllPosts``` method is implemented.
1. Re-run the application and check comments are displayed now. 

#### Server-side

The package *webapp.service* contains two implementations of the web-service: JAX-RS (Java standard for RESTful web services)
and Spring MVC (Spring Framework module for RESTful web services). Both currently return list of posts:

* [JAX-RS](http://localhost:8080/jaxrsapi/posts)
* [Spring](http://localhost:8080/posts)

Implement the following resource in both: **/comments**. The examples contain all the annotations you need:

* **JAX-RS**: @Path, @GET
* **Spring**: @RequestMapping

You will need to implement own **CommentDTO** class for serialization.

You can test your implementations at the following URLs:

* [JAX-RS](http://localhost:8080/test/jaxrs)
* [Spring](http://localhost:8080/test/spring)

### Additional Notes

* This example takes advantage of DI: We have 3 instances of PostManager and PostDao, each displaying data from different
source.
* UI is written in the [Apache Wicket](https://wicket.apache.org/) framework. Nice component-based framework for writing UIs.

## License

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
