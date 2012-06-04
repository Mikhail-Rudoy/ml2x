//"Constants"
int POPULATION_SIZE = 35;
int DRAW_OFFSET = int((pow( 2, RADIUS_GENE_SIZE ) + RADIUS_EXTRA) * 2 + 30);

//Global Variables
int popRoot = ceil(sqrt(POPULATION_SIZE));
int selectedX;
int selectedY;
int bestX;
int bestY;
boolean continuous = false;
float totalFitness = 0;
int speed;
int countdown;
int generation;
float mutationRate = 0.05;
boolean showFitness = true;

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
  speed = 20;
  countdown = 20;
  populate();
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
    i.display(showFitness);
  }
  if(continuous)
  {
    countdown--;
    if(countdown <= 0)
    {
      matingSeason();
      countdown = speed;
    }
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
  generation = 0;
  setTotalFitness();
  findBest();
  System.out.println("Total fitness is " + totalFitness);
  System.out.println("Best fitness is " + ((selected == null) ? -1 : bestI.fitness));
  System.out.println("Generation " + generation);
  System.out.println();
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
void keyPressed()
{
  switch(keyCode)
  {
    case 39:
      matingSeason();
      break;
    case 38:
      speed--;
      if(speed < 1)
      {
        speed = 1;
      }
      break;
    case 40:
      speed++;
      break;
    case 16:
      continuous = !continuous;
      break;
    case 32:
      populate();
      break;
    case 70:
      showFitness = !showFitness;
      break;
    case 77:
      mutationRate += 0.01;
      if(mutationRate > 3.0)
      {
        mutationRate = 3.0;
      }
      break;
    case 78:
      mutationRate -= 0.01;
      if(mutationRate < 0.0)
      {
        mutationRate = 0.0;
      }
  }
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
  int a = (int)random(POPULATION_SIZE);
  int b = (int)random(POPULATION_SIZE);
  while(population[a] == selected)
  {
    a = (int)random(POPULATION_SIZE);
  }
  while(population[a] == selected || a == b)
  {
    b = (int)random(POPULATION_SIZE);
  }
  if(population[a].fitness > population[b].fitness)
  {
    return population[a];
  }
  if(population[b].fitness > population[a].fitness)
  {
    return population[b];
  }
  return population[(random(2) > 1) ? a : b];
}

/*====================================
 
 Replaces the current population with a totally new one by
 selecting pairs of Individuals and "mating" them.
 Make sure that totalFitness is set before you use select().
 The goal shape (selected) should always be the frist Individual
 in the population, unmodified.
 ==================================*/

void matingSeason()
{
  int i = 0;
  Individual[] newPop = new Individual[POPULATION_SIZE];
  if(selected != null)
  {
    newPop[i] = selected;
    selectedX = 0;
    selectedY = 0;
    i++;
    selected.setPhenotype(0.5 * DRAW_OFFSET, 0.5 * DRAW_OFFSET);
  }
  while(i < POPULATION_SIZE)
  {
    newPop[i] = select().mate(select(), ((i % popRoot) + 0.5) * DRAW_OFFSET, ((i / popRoot) + 0.5) * DRAW_OFFSET);
    i++;
  }
  population = newPop;
  mutate();
  
  setTotalFitness();
  findBest();
  generation++;
  System.out.println("Total fitness is " + totalFitness);
  System.out.println("Best fitness is " + ((selected == null) ? -1 : bestI.fitness));
  System.out.println("Generation " + generation);
  System.out.println();
}

/*====================================
 
 Randomly call the mutate method an Individual (or Individuals)
 in the population.
 ==================================*/
void mutate()
{
  for(Individual i : population)
  {
    if(i == null || i == selected)
    {
      continue;
    }
    for(int j = 0; j < (int)mutationRate; j++)
    {
      i.mutate();
    }
    if(random(1) < mutationRate - (int)mutationRate)
    {
      i.mutate();
    }
  }
}

/*====================================
 
 Set the totalFitness to the sum of the fitness values
 of each individual.
 Make sure that each individual has an accurate fitness value
 ==================================*/
void setTotalFitness()
{
  totalFitness = 0;
  for(Individual b : population)
  {
    if(b == null)
    {
      continue;
    }
    if(selected == null)
    {
      b.setFitness((int)random(20));
    }
    else
    {
      b.setFitness(selected);
    }
    if(b != selected)
    {
      totalFitness += b.fitness;
    }
  }
  if(selected == null)
  {
    totalFitness = -1;
  }
}

/*====================================
 Fill the population with randomly generated Individuals
 Make sure to set the location of each individual such that
 they display nicely in a grid.
 ==================================*/
void populate()
{
  population = new Individual[POPULATION_SIZE];
  for(int i = 0; i < POPULATION_SIZE; i++)
  {
    population[i] = new Individual(((i % popRoot) + 0.5) * DRAW_OFFSET, ((i / popRoot) + 0.5) * DRAW_OFFSET);
  }
  generation = 0;
  selectedX = 0;
  selectedY = 0;
  selected = population[0];
  setTotalFitness();
  findBest();
  System.out.println("Total fitness is " + totalFitness);
  System.out.println("Best fitness is " + ((selected == null) ? -1 : bestI.fitness));
  System.out.println("Generation " + generation);
  System.out.println();
}

/*====================================
 Go through the population and find the Individual with the 
 highest fitness value.
 Set bestX and bestY so that the best Individual can have a 
 square border drawn around it.
 ==================================*/
void findBest()
{
  bestI = null;
  bestX = -1;
  bestY = -1;
  if(selected == null)
  {
    return;
  }
  for(int i = 0; i < POPULATION_SIZE; i++)
  {
    Individual I = population[i];
    
    if(I == selected || I == null)
    {
      continue;
    }
    if(bestI == null || I.fitness > bestI.fitness)
    {
      bestI = I;
      bestX = (i % popRoot);
      bestY = (i / popRoot);
    }
  }
}


