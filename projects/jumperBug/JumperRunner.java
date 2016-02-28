/**
 * Jumper runner creates an actor world and places a rock, boxbug, and jumper within it. for the purposes of testing
 * the boxbug does not move, but just stays in place to act as a test dummy.
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
public class JumperRunner
{
    public static void main(String[] args)
    {
        Jumper jumper = new Jumper();
        BoxBug boxy = new BoxBug(0);
        ActorWorld world = new ActorWorld();
        world.add(new Location(4,4), jumper);
        world.add(new Location(2,4), new Rock());
        world.add(new Location(4,6), boxy);
        world.show();
    }
}
