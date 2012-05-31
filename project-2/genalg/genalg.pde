//"Constants"
int POPULATION_SIZE = 36;
int DRAW_OFFSET = int((pow( 2, RADIUS_GENE_SIZE ) + RADIUS_EXTRA) * 2 + 30);

//Global Variables
int popRoot = ceil(sqrt(POPULATION_SIZE));
int selectedX;
int selectedY;
int bestX;
int bestY;
boolean continuous = false;
float totalFitness;
int speed;
int generation;
float mutationRate = 0.05;

//The actual individuals
Individual[] population;
Individual selected;
Individual bestI;


/*=====================================
 Create an initial population of randomly
 generated individuals.
 Setup the basic window properties
 ====================================*/
void setup()
{
  size(DRAW_OFFSET * popRoot, DRAW_OFFSET * popRoot);
  population = new Individual[POPULATION_SIZE];
  for(int i = 0; i < POPULATION_SIZE; i++)
  {
    population[i] = new Individual(((i % popRoot) + 0.5) * DRAW_OFFSET, ((i / popRoot) + 0.5) * DRAW_OFFSET);
  }
  selectedX = -1;
  selectedY = -1;
  selected = null;
  bestX = -1;
  bestY = -1;
  bestI = null;
}

/*=====================================
 Redraw every Individual in the population
 each frame. Make sure they are drawn in a grid without
 overlaping each other.
 If an individual has been slected (by the mouse), draw a box
 around it and draw a box around the individual with the
 highest fitness value.
 If mating mode is set to continuous, call mating season
 ====================================*/
void draw()
{
  background(255);
  stroke(0, 0, 255);
  fill(250);
  rect(selectedX * DRAW_OFFSET + 5, selectedY * DRAW_OFFSET + 5, DRAW_OFFSET - 10, DRAW_OFFSET - 10);
  stroke(0);
  rect(bestX * DRAW_OFFSET + 5, bestY * DRAW_OFFSET + 5, DRAW_OFFSET - 10, DRAW_OFFSET - 10);
  for(Individual i : population)
  {
    i.display();
  }
  if(continuous)
  {
    matingSeason();
  }
}

/*=====================================
 When the mouse is clicked, set selected to
 the individual clicked on, and set 
 selectedX and selectedY so that a box can be
 drawn around it.
 ====================================*/
void mouseClicked()
{
  selectedX = (int)(mouseX / DRAW_OFFSET);
  selectedY = (int)(mouseY / DRAW_OFFSET);
  if(selectedX + popRoot * selectedY >= 0 && selectedX + popRoot * selectedY < POPULATION_SIZE)
  {
    selected = population[selectedX + popRoot * selectedY];
  }
  else
  {
    selected = null;
    selectedX = -1;
    selectedY = -1;
  }
}

/*====================================
 The following keys are mapped to actions:
 
 Right Arrow: move forard one generation
 Up Arrow: speed up when in continuous mode
 Down Arrow: slow down when in continuous mode
 Shift: toggle continuous mode
 Space: reset the population
 f: toggle fitness value display
 m: increase mutation rate
 n: decrease mutation rate
 ==================================*/
void keyPressed() {
  println(keyCode); //wil display the integer value for whatever key has been pressed
}


/*====================================
 select will return a pseudo-random chromosome from the population
 Uses roulette wheel selection:
 A random number is generated between 0 and the total fitness 
 Go through the population and add each member's fitness until you exceed the random 
 number that was generated.
 Return the individual that the algorithm stopped on
 Do not include the "selected" shape as a possible return value
 ==================================*/
Individual select() {
  return null;
}

/*====================================
 
 Replaces the current population with a totally new one by
 selecting pairs of Individuals and "mating" them.
 Make sure that totalFitness is set before you use select().
 The goal shape (selected) should always be the frist Individual
 in the population, unmodified.
 ==================================*/

void matingSeason() {
}

/*====================================
 
 Randomly call the mutate method an Individual (or Individuals)
 in the population.
 ==================================*/
void mutate() {
}

/*====================================
 
 Set the totalFitness to the sum of the fitness values
 of each individual.
 Make sure that each individual has an accurate fitness value
 ==================================*/
void setTotalFitness() {
}

/*====================================
 Fill the population with randomly generated Individuals
 Make sure to set the location of each individual such that
 they display nicely in a grid.
 ==================================*/
void populate() {
}

/*====================================
 Go through the population and find the Individual with the 
 highest fitness value.
 Set bestX and bestY so that the best Individual can have a 
 square border drawn around it.
 ==================================*/
void findBest() {
}


