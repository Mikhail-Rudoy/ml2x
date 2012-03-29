import java.io.*;
import java.util.*;
import java.lang.*;

public class Solver
{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private boolean solved = false;
    private Random r;
    
    public Solver(String filename, int cols, int rows)
    {
	maxx = cols;
	maxy = rows;
	maze = new char[maxx][maxy];
	
	r = new Random();
	
	//open the maze file for reading
	String line;
	Scanner sc = null;
	try
	{
	    sc = new Scanner(new File(filename));
	}
	catch(Exception e)
	{
	    System.out.println("Can't read " + filename);
	    System.exit(0);
	}
	
	//read the file
	int y = 0;
	while (sc.hasNextLine())
	{
	    line = sc.nextLine();
	    for(int i = 0; i < line.length(); i++)
	    {
		maze[i][y] = line.charAt(i);
	    }
	    y++;
	}
	//set startx and starty accordingly
	findStart();
    }
    
    public String toString()
    {
	//start writing at the top-left corner of the terminal
	String s = "[0;0H"; 
	
	for(int y = 0; y < maxy; y++)
	{
	    for (int x = 0; x < maxx; x++)
	    {
		s = s + maze[x][y];
	    }
	    s = s + "\n";
	}
	s=s+"\n\n";
	return s;
    }
    
    /*======== public void delay() ==========
      Inputs:  int i 
      Returns: 

      Causes the program to "sleep" for i milliseconds
      ====================*/
    public void delay(int i)
    {
	try
	{
	    Thread.sleep(i);
	}
	catch (InterruptedException e)
	{
	    
	}
    }
    
    /*======== public void findStart()) ==========
      Inputs:   
      Returns: 

      Start is dennoted by the 'z' character in
      the maze
      Sets startx and starty to the coordinates of
      the start character
      ====================*/
    public void findStart()
    {
	for(int y = 0; y < maxy; y++)
	{
	    for (int x = 0; x < maxx; x++)
	    {
		if(maze[x][y] == 'z')
		{
		    startx = x;
		    starty = y;
		    return;
		}
	    }
	}
	throw new IllegalStateException();
    }
    
    /*======== public void solve1() ==========
      Inputs:   
      Returns: 

      Wrapper method for the recursive solve method.
      ====================*/
    public void solve1()
    {
	maze[startx][starty]= '#';
	solve1(startx, starty);
    }
    
    /*======== public void solve1() ==========
      Inputs:  int x
               int y 
      Returns: 

      Finds a path from (x, y) to the end of the maze, 
      marked with a '$'.
      Should keep track of which spaces have been visited 
      and are on the path vs visited and are not on the path.
      Should be a recursive solution

      Use the delay() method so that you can watch the maze
      get solved over time.      
      ====================*/
    public void solve1(int x, int y)
    {
	System.out.println(this);
	delay(37);
	if(maze[x][y] == '$')
	{
	    solved = true;
	    return;
	}
	maze[x][y] = 'X';
	ArrayList<Integer> dirs = new ArrayList<Integer>();
	if(maze[x+1][y] == '#' || maze[x+1][y] == '$')
	{
	    dirs.add(0 + 'd');
	}
	if(maze[x-1][y] == '#' || maze[x-1][y] == '$')
	{
	    dirs.add(0 + 'a');
	}
	if(maze[x][y+1] == '#' || maze[x][y+1] == '$')
	{
	    dirs.add(0 + 'w');
	}
	if(maze[x][y-1] == '#' || maze[x][y-1] == '$')
	{
	    dirs.add(0 + 's');
	}
	while(!solved)
	{
	    if(dirs.size() == 0)
	    {
		System.out.println(this);
		delay(37);
		maze[x][y] = 'O';
		return;
	    }
	    int d = dirs.remove(r.nextInt(dirs.size()));
	    switch(d)
	    {
	    case 'w':
		solve1(x, y + 1);
		break;
	    case 'a':
		solve1(x - 1, y);
		break;
	    case 's':
		solve1(x, y - 1);
		break;
	    case 'd':
		solve1(x + 1, y);
		break;
	    }
	}
    }
    
    /*======== public void solve1() ==========
      Inputs:   
      Returns: 

      Wrapper method for the recursive solve method.
      ====================*/
    public void solve2()
    {
	maze[startx][starty]= '#';
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(startx);
	q.add(starty);
	solve2(q);
    }
    
    /*======== public void solve1() ==========
      Inputs:  int x
               int y 
      Returns: 

      Finds a path from (x, y) to the end of the maze, 
      marked with a '$'.
      Should keep track of which spaces have been visited 
      and are on the path vs visited and are not on the path.
      Should be a recursive solution

      Use the delay() method so that you can watch the maze
      get solved over time.      
      ====================*/
    public void solve2(Queue<Integer> q)
    {
	System.out.println(this);
	delay(37);
	if(q.peek() == null)
	{
	    return;
	}
	int x = q.remove();
	int y = q.remove();
	if(maze[x][y] == '$')
	{
	    solved = true;
	    return;
	}
	if(maze[x][y] == 'X')
	{
	    solve2(q);
	    return;
	}
	maze[x][y] = 'X';
	if(maze[x+1][y] == '#' || maze[x+1][y] == '$')
	{
	    q.add(x + 1);
	    q.add(y);
	}
	if(maze[x-1][y] == '#' || maze[x-1][y] == '$')
	{
	    q.add(x - 1);
	    q.add(y);
	}
	if(maze[x][y+1] == '#' || maze[x][y+1] == '$')
	{
	    q.add(x);
	    q.add(y + 1);
	}
	if(maze[x][y-1] == '#' || maze[x][y-1] == '$')
	{
	    q.add(x);
	    q.add(y - 1);
	}
	solve2(q);
    }
    
    public static void main(String[] args)
    {
	Solver s = new Solver("maze.dat",70,20);
	
	System.out.println("[2J"); //clears the screen
	System.out.println(s);
	
	s.solve2();
    }
}