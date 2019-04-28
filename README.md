[![Build Status](https://travis-ci.com/majikandy/15marketing_test.svg?branch=master)](https://travis-ci.com/majikandy/15marketing_test)

# Coding Challenge

Sample code demonstrating TDD, DI and mocking

*Note: only a couple of sample API methods partially modelled due to time constraints*

This project is written in Kotlin and uses gradle for builds

## To Run Tests

./gradlew test build --info

(Or import into Intellij IDEA and run Verification -> Tests on the gradle menu)


## View test results with Docker

Considering this is just a coding challenge, instead of hosting the JVM and kotlin app in the container, the dockerfile produces a bare nginx container and hosts the test results

```
docker build -t majikandy/15marketing_test .
docker run -p 80:80 majikandy/15marketing_test
```

Then navigate to http://localhost/TEST-GameApiTests.xml

Note: this could have been done with a multistage build in docker where stage one builds and runs the tests (similar to what travis is doing) and then copies the result into stage 2 nginx image.


# Next steps

For Continuous Delivery, the docker image can be build and pushed to a container registry on success of develop branch. 

The production environment could pull the latest container on merge to master. Though this model has a slight risk of direct master commits happening outside of the dev pipeline causing unneccessary pull of latest passing develop container.
