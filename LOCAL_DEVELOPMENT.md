# Instructions regarding local development

### Prerequisites

* JDK >= 8 installed

### Recommended

* gdub installed

## Application

build app:

    gw build
    
run unit tests

    gw test
    
start app:

    gw bootRun
    
## A few words

After an successful build a fat-jar will be created under `build/libs/$artifactname`.
This Jar includes everything the Application needs to run - embedded server as well as
all frontend (bundled react app & bundled stylesheet) related stuff.



