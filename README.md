# IST 261

Fall 2017

Author: Joshua Irwin (jpi5033)

Git Repo: https://github.com/jmi0920/ist261

This ReadMe serves to document progress on the IST 261 project as it is built upon.
Updates will be split into their relevant section headers as listed on Canvas.

==== Module 01: Project Proposal ====

[Project Proposal](https://drive.google.com/file/d/0B66X1gId2oGROXlfSXYzRkhuTkE/view?usp=sharing)

    Created Project Proposal,
    Idea is to crate an application that will read in data from a text file (or
    multiple), which will populate data to allow a 'Phone Finder' application.
    This is supposed to help the user when shopping for phone by comparing 
    different phones that are offered at different carriers so that they can 
    find the cheapest phone with a plan that will suit their needs.

    [Possible Extra Ideas]
        * Populate the text field based on data gathered from the Internet.
        * Convert to web application.

====  Module 02: Identify and Design Model Classes ====

[CRC Cards](https://drive.google.com/file/d/0B66X1gId2oGROVlvV0hTb2IxUEk/view?usp=sharing)

    Identified 5 Java classes for the project.
        1. Phone
        2. Carrier
        3. Plan
        4. Option
        5. Feature

    These classes are the base ones identified so far to lay the ground work for
    the project and allowed for work to begin writing functions for each class
    once it was identified what they would be handling.

====  Module 03: Writing Tests for Model Classes ====

    Assignment requires two classes to have JUnit Tests written for them. Chose 
    Phone.java and Carrier.java for the manual unit tests. These classes also 
    have functions that call on other classes as well, so by choosing those two
    the tests are testing all five classes that were identified in Module 02.

    For the created automatic JUnit Tests, the Phone, Plan, and Option
    classes were chosen.

    *Edit(9/16/17) Automatic JUnit Tests required to be different from 
    handwritten tests, creating Option as well for automatic tests.

==== ApplicationHome ====
    Added interface home page using JavaFX, found in ApplicationHome.java,
    Shift + F6 in class to run.

    *May need to rewrite into Swing.

====  Module 04: Implementing Inheritance-Polymorphism ====
 
    Assignment 01 requires a super class to be identified and then sub-classes
    then created that inherit functions from their super class. I have 
    identified Phone.java as the super class and the from there, created three
    sub-classes (Android, Apple, Other). Selection of sub-classes based off the 
    two phone operating systems that dominate the market and then a third 
    sub-class that will handle any other type of phone. Each sub class has
    methods that are specific to the class, then an overridden method called 
    `getPhoneDetails()`. 

    Assignment 02 attempts to create an interface for the phone and plan class,
    unsure on how to implement.



    