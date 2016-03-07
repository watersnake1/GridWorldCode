import info.gridworld.actor.ActorWorld;

/**
 * Created by cmurray17 on 3/7/16.
 */
public class BlusterCritterRunner
{
    public static void main(String[] args)
    {
        BlusterCritter bluster = new BlusterCritter(4);
        ActorWorld a = new ActorWorld();
        RockHound r = new RockHound();
        a.add(r);
        a.add(bluster);
        a.show();
    }
}
