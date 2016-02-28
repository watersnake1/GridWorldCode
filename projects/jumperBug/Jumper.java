/**
 * Created by Carol on 2/28/16.
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
