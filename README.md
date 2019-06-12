# Java Web Service

This is a basic Java application with web services using Spring Boot, it was developed using Eclipse IDE and Java 8.

## How to start it:

### Using Eclipse IDE

In the Toolbar go to 'File' option and click in 'Import';

Select 'Maven', 'Existing Maven Projects' and click in 'Next';

Select directory of the project and click in Finish.

Go to 'Run' > 'Run as' and click in 'Spring Boot App'

### Command line

Open an terminal inside project path and run the following command:

```
mvn print-boot:run
```

The project should be started in: localhost:8090

## Routes

Gets the current date and time:

```
localhost:8090/gettimestamp
```

Makes a simple sum of two values:

```
localhost:8090/makesum/<value1>/<value2>
```

Makes a simple subtraction of two values:

```
localhost:8090/makesub/<value1>/<value2>
```

Makes a simple multiplication of two values:

```
localhost:8090/makemul/<value1>/<value2>
```

Makes a simple division of two values:

```
localhost:8090/makediv/<value1>/<value2>
```

Send and save a message in the application database:

```
localhost:8090/store/<message>
```
