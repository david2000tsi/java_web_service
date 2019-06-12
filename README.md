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
localhost:8090/message/save/<message>
```

Gets all messages:

```
localhost:8090/message/get
```

Updated message by id:

```
localhost:8090/message/update/<id>/<new_message>
```

Delete message by id:

```
localhost:8090/message/delete/<id>
```

### Message example

Create a new message (using %20 as space):

```
localhost:8090/message/save/This%20is%20a%20test%20message!!!
```

See message and get the id:

```
localhost:8090/message/get
```

Supposing that message id is 1, let's go to update the message (using %20 as space):

```
localhost:8090/message/update/1/We%20are%20updating%20the%20saved%20message!
```

Gets the message again to see if it was updated:

```
localhost:8090/message/get
```

Delete the message:

```
localhost:8090/message/delete/1
```
