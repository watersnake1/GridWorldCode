import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Created by cmurray17 on 3/8/16.
 */
public class QuickCrab extends CrabCritter
{
    /**
     * gets the move locations including the locations two steps away to the right and left
     * @return
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        getTwoStepLocs(locs,getDirection()+Location.LEFT);
        getTwoStepLocs(locs,getDirection()+Location.RIGHT);
        if (locs.size()==0)
        {
            return super.getMoveLocations();
        }
        return locs;
    }

    /**
     * Makes the actual valid move locations two steps away into the arraylist
     * @param locs
     * @param dir
     */
    public void getTwoStepLocs(ArrayList<Location> locs, int dir)
    {
        Location loc = getLocation().getAdjacentLocation(dir);
        if (getGrid().isValid(loc) && getGrid().get(loc) == null)
        {
            Location loc1 = loc.getAdjacentLocation(dir);
            if (getGrid().isValid(loc1) && getGrid().get(loc1) == null)
            {
                locs.add(loc1);
            }
        }

    }
}
