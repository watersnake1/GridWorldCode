import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Created by cmurray17 on 3/4/16.
 */
public class RockHound extends Critter
{
    /**
     * get all the rocks in the actors array list and remove any that are rocks
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a: actors)
        {
            if (a instanceof Rock)
            {
                a.removeSelfFromGrid();
            }
        }
    }

    /**
     * TESTING FOR BLUSTER CRITTER PLEASE IGNORE
     */
    public void makeMove(Location loc)
    {
        return;
    }
}
