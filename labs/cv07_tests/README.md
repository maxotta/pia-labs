# KIV/PIA Labs Tests and Logs Project

Spring implementation of a simple web application with tests.

     
## Tests

1. Check classes ending with Test in src/test/java folder. Compare stubs vs mocks.
1. Implement tests for userManager.authenticate method.
1. Check class ending with IT in the same package.
1. Implement test for userManager.authenticate method.

### Notes

Unit tests are being run automatically during build.

Integration tests are run using Maven Failsafe plugin.

## Logs

1. Check Logger instance in DefaultUserManager class and its uses in registerUser method.
1. Check srcm/main/resources/logback.xml
1. Try to create new log messages throughout code with different levels and create new logger
in logback.xml with different package names and levels allowed.

## License

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.