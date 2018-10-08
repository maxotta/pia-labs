WebService Lab
==========

Lab for WebService client and server demonstration.


This example has been created for a Internet Application Programming (KIV/PIA) labs at the Department of Computer Science,
University of West Bohemia in Pilsen, Czech Republic.

## WebServices

* Check dao.jaxrs package for client-side implementation.
* Check service package for server-side implementation

### WS API

Mock service and WS API description is located at [Apiary.io](http://docs.springlab.apiary.io/)

Apiary.io is a tool for web service API specification using Markdown syntax. Except for pretty documentation,
you get a mock server responding with provided examples and client code generator in various programming languages.

Your API blueprint can be automatically linked to the project repository at GitHub.

### Tests
The example contains two implementations of the same test class. One uses own stub implementation of PostDao,
the other uses Mockito framework to mock the PostDao instead.

The test are marked as **@Ignored** for now - their Spring configuration is missing. Can you fix that?

## License

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
