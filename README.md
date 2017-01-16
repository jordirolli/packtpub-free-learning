## Synopsis

This project consists on the implementation of a selenium test in order to automatically add to your user account the
e-book that is offered for free on the day of the execution.

Note 1: In order to run the test you will need to set up an account on [packtpub](https://www.packtpub.com).

Note 2: A different e-book is given for [free](https://www.packtpub.com/packt/offers/free-learning) every day.

## Motivation

I found myself accessing and downloading the e-book offered for free on a daily basis. The motivation for this project
is to perform this tasks automatically so I do not have to bother.

## Installation

In order to run this test you need to have [java](https://java.com/en/download/help/download_options.xml) and [maven](http://maven.apache.org/install.html) installed in your
machine.

I had tested the execution using maven 3.3.9 and java 1.7.0_79.

In order to run the test you should run the following command:

```
mvn test -Daccount.mail=YOUR_MAIL -Daccount.password=YOUR_PASSWORD
```

Where YOUR_MAIL and YOUR_PASSWORD must be some valid credentials in order to access to packtpub.

## New desired features

* Create a Docker container with maven and java and selenium grid so the installation of this tools is not required
anymore.
* Include instructions to automate daily execution on AWS.
* Implement the test with phantomJS in order to improve performance.
* Use spring dependency injection.