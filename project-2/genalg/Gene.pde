/*=====================================
   Each gene contains the code for a specific trait
   Instance Variables:
      genotype: int array to store a binary number
      value: corresponding base 10 number of the genotype
      geneLenght: desired length of the gene
  ====================================*/


class Gene {

  int geneLength;
  int[] genotype;
  int value;
  
  /*===================================== 
  Takes the length of the gene as a parameter,
  randomly sets every bit in the genotype array to
  a 1 or a 0, then calcuate the value.
  ====================================*/
  Gene(int l)
  {
    geneLength = l;
    genotype = new int[geneLength];
    for(int i = 0; i < geneLength; i++)
    {
      genotype[i] = random(2) > 1 ? 0 : 1;
    }
    setValue();
  }
  
  /*=====================================
    Create a new gene that is a copy
    of the parameter
  ====================================*/
  Gene(Gene g)
  {
    geneLength = g.geneLength;
    value = g.value;
    genotype = (int[])g.genotype.clone();
  }
       
  /*=====================================
    Pick a random element from genotype
    and switch it from 1 to 0 or vice-versa
  ====================================*/ 
  void mutate()
  {
    int i = (int)random(geneLength);
    genotype[i] = 1 - genotype[i];
    setValue();
  }
  /*=====================================
  Go through the genotype and set value to the
  correct bast 10 equvalent of the binary number
  ====================================*/
  void setValue()
  {
    value = 0;
    for(int i = 0; i < geneLength; i++)
    {
      value += genotype[i] * (int)pow(2, i);
    }
  }
  
  /*=====================================
    Print the genotype array and value.
    used for debugging and development only
  ====================================*/
  void display() {
    
    println( genotype );
    println( value );
  }
}
