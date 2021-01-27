/*
 * Classname: Alien.java
 *
 * Version information: 1.0
 *
 * Date: 21/01/2021
 *
 * Description: The class implements an Alien for a game. The health of the alien object determines if the alien is
 * alive and or dodging. If the health attribute is 0 then the alien attribute 'dead' MUST be true. The alien cannot be
 * dodging if they are dead. Likewise, the alien cannot be dead if they health value is >0.
 * Author: Dr. Shane Wilson
 *
 */

package com.company;

public class Alien {
    //Data members
    private boolean dead;

    public boolean isDead() {
        return dead;
    }

    public boolean isDodging() {
        return dodging;
    }

    public int getAlienHealth() {
        return alienHealth;
    }

    private boolean dodging;
    private int alienHealth;

    //Class constructors
    public Alien(boolean dodging, int alienHealth) {
        //TODO: Construct the Alien object and initialise the data members appropriately.

    }

    // Methods
    //TODO: Implement appropriate getters and setters for the class

    public void dodge() {
        //TODO: Implement the method
        /*Set dodging to true if the alien is alive*/

    }

    public void hit() {
        //TODO: Implement the method
        /*Reduces the alien health by 1. Minimum Alien health should 0.*/
    }

    public void miss() {
        //TODO: Implement the method
        /*Sets dodging to false*/

    }

}
