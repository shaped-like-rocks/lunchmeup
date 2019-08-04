Frontend
========

## Prerequisites

* **none!**

The build itself will install everything it needs (like **node** and **yarn**) in the `build` folder during the gradle build.
Thereby it is ensured that everybody is working on the same version

## Recommended

* styled-components plugin for IntelliJ
* gdub installed ()

## install project

    gw yarn_install
    
## run tests

    gw check
    
## bundle project

    gw bundle
    
## Good to Know

### Testing
#### Jest
In this project we are using **jest** as test runner.

* See official [documentation](https://jestjs.io/docs/en/getting-started.html)


#### Enzyme
Enzyme is a JavaScript Testing utility for React that makes it easier to test your React Components' output. 
You can also manipulate, traverse, and in some ways simulate runtime given the output.

* See official [documentation](https://airbnb.io/enzyme/docs/guides/jest.html)
* See [cheatsheet](https://devhints.io/enzyme) for quick hints.