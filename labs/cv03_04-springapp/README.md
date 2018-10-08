# KIV/PIA Labs - Spring Intro project

Sample project with initial Spring framework configuration.

## Steps

1. Check the project configuration - *pom.xml*, *web.xml*. You should be well-acquainted with those by now.
2. What is dependency injection (DI)? What is inversion of control(IoC)? Check this great [article](http://www.martinfowler.com/articles/injection.html) by [Martin Fowler](http://www.martinfowler.com/)
3. Check DI implementation on the servlet layer in *org.danekja.edu.pia.web* packages. 
3. Application logic - where is it?

## Tasks

1. Implement new "Quote" entity with one attribute - the quote
1. Implement all components required for storing and listing quotes - dao, manager, servlet, jsp form
1. Use Spring DI to make it all work.
1. Add view and functionality for listing and removing users.
1. Add ADMIN role which has access to the list of users - ensure no other role (USER, GUEST) can remove users.

## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.