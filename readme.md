# Develop James Matcher

[![Build Status](https://travis-ci.org/halversondm/develop-james-matcher.svg?branch=master)](https://travis-ci.org/halversondm/develop-james-matcher)

An Apache James Matcher for whitelisting the local part of the email address.  This is especially useful if you want to create a large list of users and your organization recognizes multiple domains for the same user.

`mvn clean package` to build the code from source.

## Requirements

* Maven to build
* Java 8 to run

### Runtime Requirements

You'll need to place a file named `email_whitelist.txt` on the classpath of Apache James installation.