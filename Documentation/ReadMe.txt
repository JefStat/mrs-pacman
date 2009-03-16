ReadME File (By Nicole Waldrum)



This file contains the three deliverables and a description of each deliverable. 

Updated Milestone 2 (by Nicole Waldrum): 

This readme file was updated to reflect the current status of PacMan at Milestone 2.  Each new added element to the Readme file is marked by "Updated Milestone 2 (by Author)" so that it is easier to find the current and relevant information at this stage.


Updated Milestone 3 (by Nicole Waldrum):

Several improvements were implemented as can be seen by the fact that our code now compiles and runs.  Although Jen did help implement each ghosts search algorithm, it is mainly Jef, Nicole and Nahim that have completed the programming and requirements for Milestone 2 and 3.  Jen was charged with doing the test classes, however, as those were not done by March 14th, each member of the group rapidly began recovering ground on that.  The actual JavaDoc commenting was implemented as per Michael's suggestions, however, several changes were made during the refactoring of PacMan so new UML and Sequence Diagrams needed to be created.


 

UML Diagram (By Jen Kasun, Nahim Nasser, Jef Statham and Nicole Waldrum)



The UML diagram contains the list of classes that will be used to implement the PacMan Game.  As this file was just created, several classes were created to establish the implementation of the PacMan Game including a PacMan Game class which creates 5 characters (PacMan and 4 Ghosts), a free life at 10,000 points, a score and a map.  
Another class is the character class from which PacMan and the 4 Ghosts inherit.  The Character class controls the different behaviours and movements of each character.  The Map class is a dynamic array which is empty, a wall, a pac dot, a power pellet or fruit.

In addition to these given classes there is a Movement class for PacMan's moves which are key events and there is Mouse Pressed for the user other actions within the game.

Updated Milestone 2 (by Nicole Waldrum): 

Taking into account Michael’s suggestions, the subclass of Ghost was added so that the super class did not have to be changed every time the ghosts were scared, scattered or eaten.  After this initial update each group member is responsible for updating their own classes on the UML Diagram.

Nahim Nasser will be updating the Coordinate and Map Classes to reflect those that he created.  Jef Statham will update the PacManGame Class that he implemented and Nicole Waldrum will update the Character, Ghost, GhostPath, Node and the PriorityQueue Classes.


Milestone 3 (by Nicole Waldrum):

Used Violet to create the new UML diagrams based on the major changes that were made when refactoring. And to include the new classes that have since been created.  However, the test diagrams do not need to be included but based on our previous fail we decided to include them as a package.



Sequence Diagram (By Jen Kasun):



The Sequence Diagrams illustrate the life and interactions of all the classes together.  It also helps to outline the production of the classes to discover if new or better implementations can be created.

Update Milestone 2 (by Nicole Waldrum): 

After reviewing some sequence diagrams on the internet, more logical and sequential diagrams were added.  
Working on the sequence diagrams also resulted in more refinement of the UML diagrams. After this initial update each group member is responsible for updating their own classes on the Sequence Diagram.

Nahim Nasser will be updating the Coordinate and Map Classes to reflect those that he created.  Jef Statham will update the PacManGame Class that he implemented and Nicole Waldrum will update the Character, Ghost, GhostPath, Node and PriorityQueue Classes.


Milestone 3 (by Nicole Waldrum):

Recreated the new Sequence Diagrams as the refactoring process significantly changed the UML Diagram which means the Sequence Diagrams need to be significantly modified.

Several different cases were taken into consideration and notes were added for each situation so that the sequence diagram was easier to follow.  Some of the cases have yet to be implemented in the code, however, significant progress has been made since the previous milestone.


Java Classes (By Jef Statham):



These classes are created based on those listed in the UML diagram, they will be implemented at a later time.  
These classes include Ambusher, Character, Chaser, Coordinate, Fickle, Map, PacMan, PacManGame and Stupid.

Character contains PacMan and the 4 Ghosts (Ambusher, Chaser, Fickle and Stupid) each ghost will have its own personality.  The Map class contains coordinate so that the location of PacMan and the Ghosts can be maintained.  The PacManGame contains everything so that the user can play the game.

Update Milestone 2 (by Jen Kasun, Nahim Nasser, Jef Statham and Nicole Waldrum):  

Began implementing and refining the created classes.

Nahim Nasser implemented the Coordinate and Map Classes.  The Coordinate Class extends java.Point and creates a point with an identity such as Empty Space [0], Wall [1], etc.  The Map Class is a 2D array of coordinates that contains key locations such as PacManStart and GhostPrison.  It also has a printtoConsole function to test.

PacManGame was implemented by Jef Statham.  It contains the main program but also creates a new game, controls the rule set of the game, accepts user input and notifies its observers.

The Character Class was implemented by Nicole Waldrum. It is an abstract class which gets overridden by Ghost and PacMan.  Ghost creates a constructor of the Ghost and moveToPacMan but that will be overridden by each Ghost's personality when they are implemented.  Ghost also contains moveToPrison and runAway which will be key functions when a Ghost dies or is scared.  

GhostPath, Node and PriorityQueue were implemented by Nicole Waldrum but as per Professor Esfandiari's suggestion the wheel was not invented again. The original code came from http://www.ipaladin.net/astar/ and was modified to suit the need of PacMan.  Although the code has been modified and compiled, it has yet to be determined if the A* Search Algorithm will properly determine the Ghost's AI location of PacMan and the shortest route with its current code.  Once this code works, it will then be reversed so that they Ghost may also runAway from PacMan as well.

The JUnit Testing was done by Jen Kasun.  As Jen greatly enjoys JUnit testing she volunteered to complete this task. Jen will be doing extensive testing of each of the other group member’s classes, depending upon the errors, Jen will either correct the error herself or she will contact the appropriate group member to fix the problem.

Milestone 3 (by Nahim Nasser, Jef Statham, Nicole Waldrum and Jen Kasun):

March 7: 

Nicole and Jen significantly revised the ghost’s classes and implemented the logic for each individual ghost. In addition to this the logical search algorithm A* was implemented.  Slight modifications were made to the Map class in order to implement certain actions in the ghost class.

March 9th - March 16th:

Jef Statham Report:

Implemented the observer pattern for PacMan, decoupled PacManGame and Characters, fixed the stack overflow error.  Several double instances of variables in Ghost and PacMan were deleted.  Updating all characters to properly call new methods created in the Map class such as getIdentity()'s and getPosition()'s.  Added all the variables to make things function and added designs that we didn't realize we needed.

Refactored the ghost class into an interface and revamped Character so that it abstract and merely contained 2 critical classes.  Continued refinement to the movements of the ghosts and PacMan; while destroying all of Nicole’s test cases and repairing the newly implemented code. 

Nahim Nasser Report:

Created MapGUI and finished print map then completely refactored mapGUI to ensure that the code was properly implemented.  He also created his own tests for Map and redefined them based on his refactoring.

Nicole Waldrum Report:

Updated the documentation to ensure that everyone was using JavaDoc and recording their changes properly.  Continued to refine the ghost classes and began on the test cases as Jen did not complete as this was assigned task and there was no communicate with anyone in the group.

All test cases that had been implemented were destroyed by the refactoring that Jef did.  Beginning from scratch again to make the test cases better than ever.


Documentation (By Nicole Waldrum):


Documentation for each class is contained before the class is designed.  Documentation regarding the data structures used is contained in the UML and more detail is in a Data Structures file.

Milestone 3 (By Nicole Waldrum):

Changed all the documentation in PacMan to JavaDoc, added all the parameters, returns, authors and dates as required.  everyone is encouraged to ensure that they keep their own documentation similar to the newly implemented JavaDoc documentation.


User Manual (by Nahim Nasser):


The User Manual is a signal page designed as a summary page.  There are screen shots to show what is expected on the map and the movement GUI.  There is also a legend to describe what each item is.  In addition to this, there is a brief explanation as to the purpose of the game and how to win.
