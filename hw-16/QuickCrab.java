import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
    public ArrayList<Location> getMoveLocations()
    {
	ArrayList<Location> result = new ArrayList<Location>();
	Location r1 = getLocation().getAdjacentLocation(getDirection() + Location.RIGHT);
	if(getGrid().isValid(r1))
	{
	    Location r2 = r1.getAdjacentLocation(getDirection() + Location.RIGHT);
	    if(getGrid().isValid(r2) && getGrid().get(r1) == null && getGrid().get(r2) == null)
	    {
		result.add(r2);
	    }
	}
	Location l1 = getLocation().getAdjacentLocation(getDirection() + Location.LEFT);
	if(getGrid().isValid(l1))
	{
	    Location l2 = l1.getAdjacentLocation(getDirection() + Location.LEFT);
	    if(getGrid().isValid(l2) && getGrid().get(l1) == null && getGrid().get(l2) == null)
	    {
		result.add(l2);
	    }
	}
	return result.size() > 0 ? result : super.getMoveLocations();
    }

    public static void main(String[] args)
    {
	ActorWorld world = new ActorWorld();
	world.add(new Rock());
	world.add(new Rock());
	world.add(new QuickCrab());
	world.show();
    }
}