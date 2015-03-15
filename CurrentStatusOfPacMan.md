Just to let everyone know what Jen and I did over the weekend.

# Introduction #

Essentially Jen and I went through implementing everything until PacMan compiled error-free


# Details #

## GhostPath ##

Completely implemented along with each of the Ghost class personality.  There was a great deal of effort that went into ensuring that the Ghost personalities were properly produced.  Except for Ambusher, who's personality goes twice as fast as another ghost but needs to take a more aroundabout route to PacMan.

## PacMan ##
This character class was implemented with just basic skills, more complex elements will be added later.

## Map ##
This class lacked a default constructor which was created with a MAX = 30 default size.  In addition to this, Ambusher starts outside of the jail so a position was created with getAmbusherStart.  Although Jen and I just realized that Ambusher is the pink ghost and it is Chaser, the red ghost, that starts outside the prison. This will need to be corrected.

## PacManGame ##
We change setMap into creating a default map with the MAX size.  Also, the GUI was modified so it uses the MapGUI that Nahim created.

## Node ##
Modified to return a position as this was needed to convert the vectors in the A-Star Search Algorithm to produce the coordinate of the shortest path.

## The A-Star Search Algorith ##
Chosen over the Djisktra Search Algorithm, as the A-Star Search is easier to implement and more precise for the path finding methods that we required.