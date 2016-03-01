/**
 * Created by Jay Zhu, Jon Busa and Christian Murray
 * Ver. Feb. 29 2016
 *
 * Jumper Questions
 * a.   If there is a rock or flower two spaces ahead of the jumper
 *      then it will not move, but turn by 90 degrees to the right.
 *
 * b.   If the two spaces ahead does not exist, the jumper will not
 *      move, but turn by 90 degrees to the right.
 *
 * c.   The jumper should turn by 90 degrees to the right.
 *
 * d.   The jumper should eat the actor that is sitting on the place
 *      two in front of it if it is another bug.
 *
 * e.   The jumper would eat the jumper that is in its path.
 *
 * f.   We should still test some of the methods from the bug class
 *      to make sure that the Jumper can do everything that a bug can do.
 *
 * Design
 * a.   The Jumper should extend the Bug class.
 *
 * b.   The BoxBug class is simular, but a BoxBug only moves one grid at
 *      a time.
 *
 * c.   Yes there should be a constructor for Jumper class, but it doesn't
 *      take in any parameters.
 *
 * d.   The canMove() method overrides the origin canMove() in the Bug class.
 *
 * e.   The act() method was added only for Jumper class to move the bug two
 *      grids at a time.
 *
 * f.   We should write a Jumper tester, and test all the methods from the
 *      Jumper class to see if all of them functions correctly.
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug
{
    Location nextJump;
    Grid grid;

    public Jumper()
    {

    }

    /**
     * The jumper will take two steps with every call to <code>act()</code> that is made.
     * Jumpers are very hungry, and will eat other bugs and jumpers that are on the grid.
     * Jumpers will not step on rocks or flowers but instead will jump over them or turn
     * to go around them.
     * When at the edge of a grid the jumper will turn 90 degrees until it can make a valid jump, and will
     * do the same if the space two paces in front of it is invalid.
     *
     */
    public void act()
    {
        nextJump = getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if(canMove())
        {
            moveTo(nextJump);
        }
        else
        {
            turn();
            turn();
        }
    }

    /**
     * The <code>canMove()</code> method from the <code>Bug</code> class, changed so that it checks two spaces ahead
     * instead of one, and checks for rocks as well as flowers.
     * @return true if the bug can move and false if the bug cannot
     */
    @Override
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        //if the grid does not exist
        if (gr == null)
            return false;
        Location loc = getLocation();
        //get the location that is two spaces in front of it instead of one
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        //if the location does not exist
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if (neighbor == null)
        {
            return true;
        }
        else if (neighbor instanceof Rock || neighbor instanceof Flower)
        {
            return false;
        }
        return true;
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
