# Develop James Matcher

An Apache James Matcher for whitelisting the local part of the email address.  This is especially useful if you want to create a large list of users and your organization recognizes multiple domains for the same user.

`mvn clean package` to build

## Requirements

Maven
Java 8

### Runtime Requirements

You'll need to place a file named `email_whitelist.txt` on the classpath of Apache James installation.