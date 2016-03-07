import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import sun.jvm.hotspot.memory.LoaderConstraintEntry;

import javax.security.auth.callback.LanguageCallback;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by cmurray17 on 3/4/16.
 */
public class BlusterCritter extends Critter
{
    private int c;
    private Actor self;
    private int count;

    /**
     * create a new Bluster Critter
     * @param c the courage level of the bluster critter
     */
    public BlusterCritter(int c)
    {
        super();
        this.c = c;
        self = this;
        count = 0;
    }

    /**
     * get all the actors within two steps of the critter to be processed
     * @return

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location l = getLocation();
        for (int i = l.getRow()-2; i <= l.getRow(); i++)
        {
            for (int x = l.getCol()-2; x <= l.getCol(); x++)
            {
                Location loc = new Location(i,x);
                if (getGrid().isValid(loc))
                {
                    Actor actor = getGrid().get(loc);
                    if (actor != null && actor != self)
                    {
                        actors.add(actor);
                    }
                }
            }
        }
        return actors;
    }
    
    /**
     * get all the actors to be processed, counting all the instances of critter present in the array
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a: actors)
        {
            if (a instanceof Critter)
            {
                count++;
            }
        }
        if (count > c)
        {
            darken();
        }
        if (count < c)
        {
            brighten();
        }
    }

    /**
     * set the color of the critter to be slightly brighter than it was before
     */
    public void darken()
    {
        Color color = getColor();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        if (r > 0)
        {
            r--;
        }
        if (g > 0)
        {
            g--;
        }
        if (b > 0)
        {
            b--;
        }

        setColor(new Color(r,g,b));
    }

    /**
     * set the color of the critter to be slightly darker than it was before
     */
    public void brighten()
    {
        Color color = getColor();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        if (r < 255)
        {
            r++;
        }
        if (g < 255)
        {
            g++;
        }
        if (b < 255)
        {
            b++;
        }

        setColor(new Color(r,g,b));
    }

    public int getCount()
    {
        return count;
    }


}
