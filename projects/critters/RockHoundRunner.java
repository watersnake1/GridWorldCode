import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;

/**
 * Created by cmurray17 on 3/4/16.
 */
public class RockHoundRunner
{
    public static void main(String[] args)
    {
        RockHound rockHound = new RockHound();
        ActorWorld actorWorld = new ActorWorld();
        actorWorld.add(rockHound);
        actorWorld.add(new Rock());
        actorWorld.show();
    }
}
