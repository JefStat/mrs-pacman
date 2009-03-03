ReadME File (By Nicole Waldrum)



This file contains the three deliverables and a description of each deliverable. 

Updated Milestone 2 (by Nicole Waldrum): 

This readme file was updated to reflect the current status of PacMan at Milestone 2.  Each new added element to the 
Readme file is marked by "Updated Milestone 2 (by Author)" so that it is easier to find the current and relevant
information at this stage.

 

UML Diagram (By Jen Kasun, Nahim Nasser, Jef Statham and Nicole Waldrum)



The UML diagram contains the list of classes that will be used to implement the PacMan Game.  As this file was 
just created, several classes were created to establish the implementation of the PacMan Game including a PacMan 
Game class which creates 5 characters (PacMan and 4 Ghosts), a Freelife at 10,000 points, a score and a map.  
Another class is the character class from which PacMan and the 4 Ghosts inherit.  The Character class controls 
the different behaviours and movements of each character.  The Map class is a dynamic array which is either empty, 
a wall, a pacdot, apower pellet or fruit.

In addition to these given classes there is a Movement class for PacMan's moves which are key events and there is 
Mouse Pressed for the user other actions within the game.

Updated Milestone 2 (by Nicole Waldrum): 

Taking into account Micheals suggestions, the subclass of Ghost was added so that the superclass did not 
have to be changed everytime the ghosts were scared, scattered or eaten.  After this initial update 
each group member is responsible for updating their own classes on the UML Diagram.

Nahim Nasser will be updating the Coordinate and Map Classes to reflect those that he created.  Jef Statham will
update the PacManGame Class that he implemented and Nicole Waldrum will update the Character, Ghost, GhostPath, Node
and the PriorityQueue Classes.



Sequence Diagram (By Jen Kasun)



The Sequence Diagrams illustrate the life and interactions of all the classes together.  It also helps to outline 
the production of the classes to discover if new or better implementations can be created.

Update Milestone 2 (by Nicole Waldrum): 

After reviewing some sequence diagrams on the internet, more logical and sequential diagrams were added.  
Working on the sequence diagrams also resulted in more refinement of the UML diagrams. After this initial update 
each group member is responsible for updating their own classes on the Sequence Diagram.

Nahim Nasser will be updating the Coordinate and Map Classes to reflect those that he created.  Jef Statham will
update the PacManGame Class that he implemented and Nicole Waldrum will update the Character, Ghost, GhostPath, Node
and PriorityQueue Classes.



Java Classes (By Jef Statham)



These classes are created based on those listed in the UML diagram, they will be implemented at a later time.  
These classes include Ambusher, Character, Chaser, Coordinate, Fickle, Map, PacMan, PacManGame and Stupid.

Character contains PacMan and the 4 Ghosts (Ambusher, Chaser, Fickle and Stupid) each ghost will have its own 
personality.  The Map class contains coordinate so that the location of PacMan and the Ghosts can be maintained.  
The PacGame contains everything so that the user can play the game.

update Milestone 2 (by Jen Kassun, Nahim Nasser, Jef Statham and Nicole Waldrum):  

Began implementing and refining the created classes.

Nahim Nasser implemented the Coordinate and Map Classes.  The Coordinate Class extends java.Point and creates a 
point with an identity such as Empty Space [0], Wall [1], etc.  The Map Class is a 2D array of coordinates that
contains key locations such as PacManStart and GhostPrison.  It also has a printtoConsole function to test.

PacManGame was implemented by Jef Statham.  It contains the main program but also creates a new game, controls the rule
set of the game, accepts user input and notifies its observers.

The Character Class was implemented by Nicole Waldrum. It is an abstract class which gets overridden by Ghost and 
PacMan.  Ghost creates a constructor of the Ghost and moveToPacMan but that will be overridden by each Ghost's 
personality when they are implemented.  Ghost also contains moveToPrison and runAway which will be key functions when
a Ghost dies or is scared.  

GhostPath, Node and PriorityQueue were implemented by Nicole Waldrum but as per Professor Esfandiari's suggestion 
the wheel was not invented again. The original code came from  http://www.ipaladin.net/astar/ and was modified to 
suit the need of PacMan.  Although the code has been modified and compiled, it has yet to be determined if the A* 
Search Algorithm will properly determine the Ghost's AI location of PacMan and the shortest route with its current 
code.  Once this code works, it will then be reversed so that they Ghost may also runAway from PacMan as well.

The JUnit Testing was done by Jen Kasun.  As Jen greatly enjoys JUnit testing she volunteered to complete this task.
Jen will be doing extensive testing of each of the other group members classes, depending upon the errors, Jen will
either correct the error herself or she will contact the appropriate group member to fix the problem.

Documentation

Documentation for each class is contained before the class is designed.  Documentation regarding the data 
structures used is contained in the UML and more detail is in a Data Structures file.