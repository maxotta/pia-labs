Spring-Lab
==========

Spring Lab example for introduction to DI, IoC, WebServices, Unit tests and mocks.


This example has been created for a Internet Application Programming (KIV/PIA) labs at the Department of Computer Science,
University of West Bohemia in Pilsen, Czech Republic.

## License

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.


## Theory

* Dependency Injection
    * Nice description at [Wikipedia](http://en.wikipedia.org/wiki/Dependency_injection)
    * Check especially the examples section!
* Inversion of Control
    * TBD

## Project Structure
Application parts are wired together using Spring framework (see ``applicationContext.xml`` and ``applicationContext-test.xml`` in
``main/resources`` and ``/test/resources`` folders).

* ``core.posts.domain`` contains domain objects (inner representation of data
* ``core.posts.manage`` contains manager classes for the data (application logic)
* ``core.posts.service`` contains client interface for connection to a web service and data retrieval (NOTE, this is basically a DAO)
* ``core.posts.service.dto`` contains Data Transfer Objects used for (De)serializaiton of the data retreived via web service. While in this example
  they have the same structure as domain objects, in the real world they can represent only a subset of a domain class or even have a completelly different
  structure
* ``webapp.components`` contains custom wicket components - components should contain main part of display logic
* ``webapp.pages`` contains wicket pages - pages should be used for parameter parsing and basic layout (dont make large pages, decompose into components instead)


### Tests
The example contains two implementations of the same test class. One uses own stub implementation of PostServiceClient,
the other uses Mockito framework to mock the PostServiceClient instead.

### Commands

* To run the project, exec ``mvn jetty:run``
* To build the project and run tests, exec ``mvn install``

### WS API

Mock service and WS API description is located at [Apiary.io](http://docs.springlab.apiary.io/)

Apiary.io is a tool for web service API specification using Markdown syntax. Except for pretty documentation,
you get a mock server responding with provided examples and client code generator in various programming languages.

Your API blueprint can be automatically linked to the project repository at GitHub.

## Tasks

1. Get familiar with the project
    * Spring configuration, application context
    * Unit tests - stubs, mocks
1. Try to start the application and go to ``/posts`` page.
    * If fails... :)
2. Define PostManager bean and try again.
3. Finish the functionality - comments are not displayed for their quotes at the moment.
    * Implement remaining methods of the provided PostServiceClient interface.
4. Write tests to ensure your implementation is correct.
    * try using both mocks and own stubs
5. Implement CommentList wicket component.
4. Ask questions