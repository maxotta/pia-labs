# KIV/PIA Labs Example Application Project

Spring implementation of a simple web application. Provides overview of what kind of application
students should be able to create after passing the course. This implementation does not follow
the latest trends in Spring application development as it is meant to demonstrate **principles**, not
technology. Please consult Spring / Spring Boot documentation for current guidelines.

1. Get acquainted with contents of the pom.xml file.
1. Build the project using ```mvn install``` and examine contents of the created archive.

After code examination, try to start the application.
1. First we need database, we will use Docker for that. Details of how docker works will be exaplained
    in separate lab.
    ```
     docker run -ti -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7
    ```
1. Run the built application
    ```
    mvn cargo:run
    ```
1. To rebuild and update deployment, run
    ```
    mvn install
    ```    
    and restart the cargo process.
1. Interesting URLs:
    * http://localhost:8080/ (login page)
    * http://localhost:8080/register (registration page)
    * http://localhost:8080/secret/vip (not so secure page) 
    

##Importing Maven Project into Your IDE

While these tutorials may be slightly outdated due to new version releases,
 the main course of action usually remains the same.

[Import into Eclipse](https://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html)

[Import into Netbeans](http://wiki.netbeans.org/MavenBestPractices#Open_existing_project)

[Import into Intellij IDEA](https://www.jetbrains.com/idea/help/importing-project-from-maven-model.html)

## What is missing

This overview does not go into full details. Some of the concepts which are not presented here,
but will be taught during the course:

* testing
* security
* deployment
* web services


## License

Base of the JPA setup has been created by Karel Zibar during one of the courses at the University.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.