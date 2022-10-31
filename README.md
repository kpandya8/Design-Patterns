# Design Patterns:  
### (SER 515 Submission - Module 7)  
  
Design Patterns Implemented:  
1) Facade Pattern  
2) Bridge Pattern  
3) Factory Pattern  
4) Iterator Pattern  
5) Visitor Pattern  
  
## Implementation of Design Pattern:  
   
* To start the process you'll have to run the Demo.java file in intellij.  
* The Demo.java calls the Facade.java that acceses other modules in the project.  
* The Facade.java file provides interface to the login, Reminder, ProductMenu, TradingMenu, and OfferingMenu classes.  
* Once the Login promt is popped up, the bridge pattern is implemented, where the user can login either as a buyer or a seller. This is where the bridge pattern is implemented. Here once the user is logged in as a buyer or seller they can interact with the product menu, where two types of products can be choosen, MeatProduceMenu, ProduceProductMenu.  
* Factory methos is enabled in the ProductMenu.java file and Person.Java file, which decides whether to instansiate MeatProduceMenu class or ProduceProductMenu class and buyer class or seller class respectively.  
* Visitor pattern and Iterator patterns are implemented for accesing the elements of the classes without changing the elements inside the classes.

## Contents of mod7 folder:  
* assignDP.kpandya8.zip file this has all the project files.  
* Class Diagram created in Astah.  
* Astah file for the project.
* java.zip file that has skeleton code for exported from astah.
