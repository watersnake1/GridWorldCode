/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */


import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
//import sun.jvm.hotspot.memory.LoaderConstraintEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ChameleonCritter
{
    public void act()
    {
        super.act();
    }
    /**
     * Gets the actor that is immediately to its north and south
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location currentLoc = getLocation();
        int currentDirection = getDirection();
        Location aheadLoc = currentLoc.getAdjacentLocation(currentDirection);
        Location behindLoc = currentLoc.getAdjacentLocation(currentDirection - Location.HALF_CIRCLE);
        if (getGrid().isValid(aheadLoc))
        {
            Actor ahead = getGrid().get(aheadLoc);
            actors.add(ahead);
        }
        if (getGrid().isValid(behindLoc))
        {
            Actor behind = getGrid().get(behindLoc);
            actors.add(behind);
        }
        return actors;
    }

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();

        int r = (int) (Math.random() * n);

        Actor other = actors.get(r);
        if (other != null)
        {
            setColor(other.getColor());
        }
        else
        {
            setColor(getColor().darker());
        }
    }
}
