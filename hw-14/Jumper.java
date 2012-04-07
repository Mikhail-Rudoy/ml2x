import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;

public class Jumper extends Actor
{
    public Jumper()
    {
	super();
    }
    public Jumper(int direction)
    {
	super();
	setDirection(direction);
    }
    public Jumper(int direction, Color c)
    {
	super();
	setDirection(direction);
	setColor(c);
    }
    
    public boolean canMove()
    {
	return getGrid() != null && getGrid().isValid(getLocation().getAdjacentLocation(getDirection())) && getGrid().get(getLocation().getAdjacentLocation(getDirection())) == null;
    }

    public void move()
    {
	moveTo(getLocation().getAdjacentLocation(getDirection()));
    }
    
    public boolean canMove2()
    {
	return getGrid() != null && getGrid().isValid(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection())) && getGrid().get(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection())) == null;
    }

    public void move2()
    {
	moveTo(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()));
    }
    
    public void turn()
    {
	setDirection(getDirection() + Location.HALF_LEFT);
    }

    public void act()
    {
	if(canMove2())
	{
	    move2();
	}
	else if(canMove())
	{
	    move();
	}
	else
	{
	    turn();
	}
    }

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper(((int)(Math.random() * 8)) * 45));
        world.add(new Rock());
        world.show();
    }
}