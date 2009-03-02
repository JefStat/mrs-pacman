ReadME File (By Nicole Waldrum)

This file contains the three deliverables and a description of each deliverable.  

UML Diagram (By Jen Kasun, Nahim Nasser, Jef Statham and Nicole Waldrum)

The UML diagram contains the list of classes that will be used to implement the PacMan Game.  As this file was 
just created, several classes were created to establish the implementation of the PacMan Game including a PacMan 
Game class which creates 5 characters (PacMan and 4 Ghosts), a Freelife at 10,000 points, a score and a map.  
Another class is the character class from which PacMan and the 4 Ghosts inherit.  The Character class controls 
the different behaviours and movements of each character.  The Map class is a dynamic array which is either empty, 
a wall, a pacdot, apower pellet or fruit.

In addition to these given classes there is a Movement class for PacMan's moves which are key events and there is 
Mouse Pressed for the user other actions within the game.

Updated Milestone 2 (by Nicole Waldrum): Taking into account Micheals suggestions, the subclass of Ghost was added
 so that the superclass did not have to be changed everytime the ghosts were scared, scattered or eatten.

Sequence Diagram (By Jen Kasun)

The Sequence Diagrams illustrate the life and interactions of all the classes together.  It also helps to outline 
the production of the classes to discover if new or better implementations can be created.

Update Milestone 2 (by Nicole Waldrum): After reviewing some sequence diagrams on the internet, more logical and 
sequential diagrams were added.  Working on the sequence diagrams also resulted in more refinement of the UML
diagrams.

Java Classes (By Jef Statham)

These classes are created based on those listed in the UML diagram, they will be implemented at a later time.  
These classes include Ambusher, Character, Chaser, Coordinate, Fickle, Map, PacMan, PacManGame and Stupid.

Character contains PacMan and the 4 Ghosts (Ambusher, Chaser, Fickle and Stupid) each ghost will have its own 
personality.  The Map class contains coordinate so that the location of PacMan and the Ghosts can be maintained.  
The PacGame contains everything so that the user can play the game.

update Milestone 2 (by Jen Kassun, Nahim Nasser, Jef Statham and Nicole Waldrum):  Began implementing and refining
the created classes.

Documentation

Documentation for each class is contained before the class is designed.  Documentation regarding the data 
structures used is contained in the UML and more detail is in a Data Structures file.