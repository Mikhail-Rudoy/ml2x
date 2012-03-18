import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;

    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
    
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new CircleBug(3));
        world.add(new Rock());
        world.show();
    }
}