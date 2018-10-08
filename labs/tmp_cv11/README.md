# KIV/PIA Labs Example Application Project

Empty project with configured servlets and JPA, ready for creating a sample application.

## Steps

1. Check JPA configuration in applicationContext.xml. **important** parts are: entity manager factory, transaction manager
1. Check DefaultUserManager class - see the @Transactional annotation?
1. Check parameter passing - ConfigurableSecretManager and propertyConfigurer bean in applicationContext.
1. Check SpringSecurity configuration - Security section of application context, @PreAuthorize annotation in ConfigurableSecretManager
and UserDetails and UserDetailsService in User and UserDao classes.

## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.