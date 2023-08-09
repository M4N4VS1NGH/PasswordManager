# PasswordManager

A simple implementation of a Password Manager using ChatGPT-3.5

Made with Java (Amazon Corretto Version 11.0.19)

Tested with JUnit testing framework

## How To Use:

Clone the repository, and run Main.java!

## Use Cases:
* Users may define a password for a username linked to a website
* Users may receive the password based on the username and website they provide
* Users may change their password linked to a website
* Users may generate a password that will be saved
* Users may delete password information
* Users may receive a full list of websites they have login information to

## User Story:

As a user, I want to save login information, be able to retrieve the same information if I forget it in the future, be able to change the same password, generate a password, delete password information, and receive a list of websites of which I have login information to

## Design Patterns Used:

Singleton Design Pattern - To ensure the PasswordManager class has one instance which helps with managing resources

Observer Design Pattern - To help notify users if their password has been successfully saved, deleted, changed, etc.

## Remaining Code Smells:
There are some long methods in Main.java such as run(), addUserPassword(), generatePassword().
Most methods within the application should not be as long as these three.

There are also comments throughout the program, and there are a lot of comments found in Main.java.

## SOLID and Clean Architecture:

The application follows all SOLID principles and completely adheres to Clean Architecture. 
