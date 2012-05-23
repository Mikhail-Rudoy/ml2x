/*=====================================
 Each individual contains an array of genes that code for
 particular traits to be visually represented as a
 regular polygon.
 Instance variables:
 chromosome
 An array of genes, each entry corresponds to a
 specific trait in the following order:
 sides: number of sides
 length: the length of each side
 red_color: red value
 green_color: green value
 blue_color: blue value
 x_factor: "wobble" factor for x values
 y_factos: "wobbly" factor for y values
 phenotype
 A Blob object with traits the correspond to
 the values found in chromosome.
 fitness
 how "close" the Individual is to the desired state
 ====================================*/

/*=====================================
 Number of genes in each chromosome and the
 unique indentifier for each gene type
 ====================================*/
static int CHROMOSOME_LENGTH = 7;
static int SIDES = 0;
static int RAD = 1;
static int RED_COLOR = 2;
static int GREEN_COLOR = 3;
static int BLUE_COLOR = 4;
static int X_FACTOR = 5;
static int Y_FACTOR = 6;

/*=====================================
 Constants defining how long each gene will be.
 For initial development set these to lower
 values to make testing easier.
 ====================================*/
static int SIDE_GENE_SIZE = 6;
static int RADIUS_GENE_SIZE = 5;
static int COLOR_GENE_SIZE = 8;
static int FACTOR_GENE_SIZE = 4;

static int RADIUS_EXTRA = 30;

class Individual {

  //Instance variables
  Gene[] chromosome;
  Blob phenotype;
  float fitness;

  /*=====================================
   Create a new Individual
   ====================================*/
  Individual() {
    chromosome = new Gene[CHROMOSOME_LENGTH];
    fitness = 0;
  }

  /*=====================================
   Create a New Individual by setting each entry in chromosome
   to a new randomly created gene of the appropriate length.
   
   After the array is populated, set phenotype to a new Blob
   with center cx, cy and properties that align with gene values.
   (i.e. if the sides gene is 4, the Blob should have 4
   sides...)
   ====================================*/
  Individual(float cx, float cy) {
  }

  /*=====================================
   Call the display method of the phenotype, make sure to set the fill
   color appropriately
   ====================================*/
  void display(boolean sf, boolean ss) {
  }

  /*=====================================
   Set phenotype to a new Blob with center cx, cy and 
   properties that align with gene values.
   ====================================*/
  void setPhenotype(int cx, int cy) {
  }

  /*=====================================
   Print the value of each gene in chromosome, useful for
   debugging and development
   ====================================*/
  void printIndividual() {
  }

  /*=====================================
   Return a new Individual based on the genes of the calling
   chromosome and the parameter, "other". A random number of
   genes should be taken from one of the 2 individuals and the
   rest from the other.
   The phenotype of the new Individual must be set, using cs and cy
   as the center
   ====================================*/
  Individual mate(Individual other, int cx, int cy) {
    return null;
  }

  /*=====================================
   Set the fitness value of the calling individual by
   comparing it to the parameter, "goal"
   The closer the two are, the higher the fitness value
   should be
   ====================================*/
  void setFitness( Individual goal ) {
  }


  /*=====================================
   Call the mutate method on a random number
   of genes.
   ====================================*/
  void mutate() {
  }
}

