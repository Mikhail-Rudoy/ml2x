import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import java.util.ArrayList;

public class RockHound extends Critter
{
    public void processActors(ArrayList<Actor> actors)
    {
	for(Actor a : actors)
	{
	    if (a instanceof Rock)
	    {
		a.removeSelfFromGrid();
	    }
	}
    }

    public static void main(String[] args)
    {
	ActorWorld world = new ActorWorld();
	world.add(new Rock());
	world.add(new Rock());
	world.add(new RockHound());
	world.show();
    }
}