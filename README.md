# Quarkus-Openwhisk-Docker-Container
An OpenWhisk docker container for running Quarkus applications in a developer friendly way! Uses an embedded proxy* so you can use the standard Quarkus Resteasy annotations to build your application.
Check the pom.xml to see which Quarkus features/libs/jars are bundled in the container.

* the proxy used is a modified version of this:

http://jamesthom.as/blog/2019/04/29/apache-openwhisk-web-action-http-proxy/

but heavily refactored to use Java, Quarkus and bundle all the libs to get faster startup time, and a faster developer experience when developing applications.

You can rebuild this OpenWhisk action docker container with these commands (useful if you want to update the base Quarkus libs pre-installed into the container image, or want to add more libs):
```
mvn install
 docker build -t NAME/TAG .
 docker push NAME/TAG
 ```
 ## To use the prebuilt container:
 Currently this container has the libs for Quarkus 1.0.1.FINAL of Quarkus.
 
Do a:
```
mvn install
```
on your Quarkus project.

Then you need to pass your built Quarkus runner jar with the container name/tag. For example, if you're running OpenWhisk locally:
```
wsk-local action create quarkstest1 target/getting-started-1.0-SNAPSHOT-runner.jar --docker prpatel/quarkustest:latest --web true
 ```
Or if you're deploying to IBM Cloud Functions:
```
ibmcloud fn action update quarkustest1 target/getting-started-1.0-SNAPSHOT-runner.jar --docker prpatel/quarkustest:latest --web true
```
Then do:
```
ibmcloud fn action get quarkustest1 --url
```
to get the URL. If you build the example Quarkus app in this project, you can go to the URL that is returned by the above command, and append /hello and you'll see the result.
 
 
docker build -t prpatel/quarkustest:11 .
docker push prpatel/quarkustest:11
ibmcloud fn action update quarkustest1 target/getting-started-1.0.0-SNAPSHOT-runner.jar --docker prpatel/quarkustest:11 --web true
