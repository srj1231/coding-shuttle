## Concept 16: Spring Framework vs Spring Boot


| Feature         | Spring Framework                   | Spring Boot                                       |
| --------------- | ---------------------------------- | ------------------------------------------------- |
| what it is      | IoC/DI modular framework           | a tool to bootstrap Spring apps with zero configs |
| setup           | manual XML/java config             | auto config                                       |
| config          | write beans, dispatchers etc.      | almost none                                       |
| dependencies    | you add each                       | spring boot starter pack                          |
| embedded server | external Tomcat/Jetty + WAR        | built-in Tomcat/Jetty as JAR                      |
| prod ready      | you add metrics and health checks  | Actuator gives /health, /metrics out of the box   |
| use case        | full control, legacy, custom setup | fast start-up, 90% new apps                       |


## Concept 17: Internal Working of Spring Boot (Auto-configuration)

* Maven - a build automation and project management tool for Java apps. Resolves dependencies from the pom.xml into the classpath.
* All dependencies are laoded from maven central (needs internet for the first time).
* Auto-configuration configures Spring apps based on dependencies presnt isn classpath. This simplifies the setup and development.

### Working of Auto-Configuration

1. Classpath scanning - to find libraries and classes
2. Configuration classes - responsible for configuring specific parts of the application
3. Conditional beans - checks conditions and user defined properties to decide if it should be applied.


### Core Features of Auto-configuration

* @PropertySources Auto-registration (creates beans) on running the main method (@SpringBootApplication) of the application from yaml, env. variables, etc.
* META-INF Spring Framework - the app goes here and adds whichever beans should be added from a huge library.
* Enhanced Conditional Support - e.g. @ConditionalOnBean(Datasource.class) is true if user specified a datasource bean in @Conguration, @ConditionalOnClass(Datasource.class) is true if the Datasource class is on the classpath, @ConditionalOnProperty("my.prop") is set if my.prop is set.


> IOC Container scans POJO classes components like StripePayment, RazorpayPayment; takes external configs like env. variables, properties files, and returns Application Context / a bunch of beans.


1. JVM starts the main method.
2. SpringBootApplication.run(MyApp.class, args) - scans and loads auto-configs
3. Spring Boot detects these an creates SpringApplication object (Application Context, sets Environment, registers Listeners and Initializers).
4. ApplicationContext is refreshed - all beans created, dependencies autowired, lifecycle methods get called
5. Tomcat (embedded web server) is started
6. CommandLineRunners or ApplicationRunners are executed (if any)
7. App is now fully started and ready to serve requests.


## Maven Build Tools

> pom.xml is a recipe and chef maven cooks the app using dependencies incredients that come is .jar bags.

### Build Automation

* Maven has goals that it accomplishes during its life: compile > test > package > integration test > verify > install > deploy > validate > repeat.
* Maven builds and packages Spring apps into production deployable .jar files, WAR files using maven commands.
* Maven commands: maven compile creates compiles files in target, clean removes all previous builds, test, install aids in deploying packaged files for distribution, package generates .jar / WAR files in target, deploy to ship project to a remote repository.
* The jar file can be used to run the app locally without having the project installed.
* mvn spring-boot:run - runs app directly without packaging it.
* mvn spring-boot:build-image - builds a Docker image of app.


# Homework
1. list all annotations learnt so far.
2. Scenarios where Spring Framework can be very useful over NodeJS.
3. Scenarios where Spring Boot can be very useful over Spring Framework.
4. Alice and her bakery:
    * CakeBaker class dependent on Frosting and Syrup classes. Has function bakeCake.
    * Interfaces Frosting and Syrup with functions getFrostingType and getSyrupType.
    * 2 implementations of these interfaces (so total 4 classes) for Strawberry and Chocolate flavours.
    * Use DI to inject the dependencies into CakeBaker and to call bakeCake method. 