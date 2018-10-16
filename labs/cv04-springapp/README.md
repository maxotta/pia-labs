# KIV/PIA Labs - Spring Intro project

Sample project with additional Spring framework configuration - Properties, Security.

## Steps

1. Check parameter passing
1. Check SpringSecurity configuration
1. Implement own roles for users

### Parameter Passing

Means of configuring your application via files.

Spring enables specification of parameter values via expression language (*${parameterName}*). In Spring configuration
we are required to provide bean definition which handles loading the parameters from files/env variables and their 
injection into places.

#### Notable classes and files

**org.danekja.edu.pia.manager.ConfigurableSecretManager**: Requires a configuration value to be provided
**src/main/resources/applicationContext.xml**: propertyConfigurer bean

#### Tasks

1. Check the notable classes, run the application test that it works by accessing **/public/vip**.
1. Run the application with env variable **secret.value=1212**, check that it changed.

### Security - User Authentication and Authorization

Spring security provides vast configuration options. Developer is required to implement only a few custom pieces
of code:

* *UserDetails* object representing user
* *UserDetailsService* which can fetch users from persistence

#### Notable classes and files

**org.danekja.edu.pia.domain.User**: Contains UserDetails implementation
**org.danekja.edu.pia.dao.UserDaoMemorySmarter**: Contains UserDetailsService implementation
**src/main/resources/applicationContext.xml**: all configurations from **security** namespace
**org.danekja.edu.pia.dao.PasswordEncoder**: Contains Spring's PasswordEncoder interface implementation
**org.danekja.edu.pia.manager.ConfigurableSecretManager**: Contains annotation-based authorization restriction
**org.danekja.edu.pia.web.servlet.spring.SecretServlet**: shows the secret value, protected on URL level
**org.danekja.edu.pia.web.servlet.spring.UnprotectedSecretServlet**: shows the secret value, **not** protected on URL level

#### Tasks

1. Check all the relevant classes and configs, run the application
1. Try accessing **/secret/vip** and **public/vip** - we can access the secret valua via the latter, why?
1. Uncomment *@PreAuthorize* annotation in ConfigurableSecretManager and try again
1. Implement own Role system
1. **Homework**: compare with simple authentication and authorization system we had in the previous lab

##### Implementing roles

* in Spring, roles are represented by GrantedAuthorities interface
* create DAO which will hold list of roles, and enables searching them by name (add functionality is not relevant)
* wire the new dao into your system
* have two roles in your system - USER and ADMIN
* USER can see the /public/vip
* ADMIN can see the /secret/vip
* more stuff to do, e.g. USER and ADMIN could see different secrets :)

###### FAQ

* [Getting current user](https://docs.spring.io/spring-security/site/docs/4.2.9.RELEASE/reference/htmlsingle/#obtaining-information-about-the-current-user)


## Docs

* [Parametrization](https://docs.spring.io/spring/docs/4.3.19.RELEASE/spring-framework-reference/htmlsingle/#beans-environment) with much more details than this lab
* [Spring Security Guide](https://docs.spring.io/spring-security/site/docs/4.2.9.RELEASE/reference/htmlsingle) 

## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.