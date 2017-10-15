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

====  Module 05:  Implementing a Simple MVC Application ====

    Created a Controller and View class for the Phone Model. Once the controller
    is instantiated, the PhoneList class is called as well as the
    PhoneView class. The PhoneList class just creates a LinkedList of Phone
    objects and the view class then crates an interface that allows the user
    to view them, beginning at the 0 index of the array. There are four buttons
    on this interface (Next, Back, Edit, Delete). These buttons allow navigation
    and modifications of the data. Next and Back allow the user to navigate the
    interface and become disabled when the user reaches the beginning or the 
    end of the array respectively. The will also both become disabled if the 
    array becomes empty and will remain in such a state until an object is 
    created.

    The Edit and Delete buttons allow users to modify the data that is presented
    to them. Edit allows the user to modify the data on the page they are 
    currently looking at by presenting them with three consecutive JOptionPanes
    for Model, Manufacturer, and price. If the user leaves any of the fields
    blank or hits the close button all data will be discarded at the end
    and present them with an error. Otherwise once the user submits their 
    changes, the values for the object will be changed and the JFrame will be 
    updated with the new information. The delete button allows the user to 
    delete the current object they are viewing. If the button is clicked then
    a confirmation page is presented to the user verifying that they wish to 
    delete the object. If the user chooses yes, then the object is removed from
    the list and then the user is redirect to the object before or after the
    one they were previously on. If the user deletes the only object in the 
    array then instead of being redirected the fields just show null and will
    not update until an object is created.

    The ability to create a new object is the the menu bar at the top of the
    application under File. This will present the same JOptionPanes that
    are presented when the user clicks on the edit button. The same process
    applies to these fields, except once the user has submitted their values,
    a new object is created and then the user is directed to the end of the
    array where their new object exists.

====  Module 06:  Implementing the List-Detail Pattern ====

    This assignment called for a creation of a table list view for a model. For
    this I chose the Phone model. When the application is first run, a 
    populated table will be presented to the user with a few Phone objects.
    The user can then click on a specific object and 'Show Details' to view the
    phone specifically. From this page they are presented with "Edit" and 
    "Delete" buttons. The edit button will allow the user to modify the details
    of the specific object through JDialogOptions. The delete button will allow
    the user to remove the specific object and is then redirected to another 
    object. 

    The user also has the a "New Phone" button that they can click on. This 
    button will let the user add new a new Phone based on JDialogOptions and is
    then redirected to that new phone in the DetailsView.

    