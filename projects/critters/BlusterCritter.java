import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import sun.jvm.hotspot.memory.LoaderConstraintEntry;

import javax.security.auth.callback.LanguageCallback;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by cmurray17 on 3/4/16.
 */
public class BlusterCritter extends Critter
{
    private int c;

    /**
     * create a new Bluster Critter
     * @param c the courage level of the bluster critter
     */
    public BlusterCritter(int c)
    {
        this.c = c;
    }

}
