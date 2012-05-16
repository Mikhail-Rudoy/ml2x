
Blob[] blobs;
int popSize = 17;
int w, h;

/*=====================================
 The trikiest part of setup is to make 
 the screen an appropriate size for the
 grid of blobs. The grid should be just
 big enough to contain all of the blobs.
 ====================================*/
void setup() {
  w = (int)sqrt(popSize - 1) + 1;
  h = (popSize - 1) / w + 1;
  size(150 * w, 150 * h);
  background(0);
  populate();
}

/*=====================================
 The main purpose of draw is to go through 
 the array of blobs and display each.
 ====================================*/
void draw() {
  background(0);
  for (Blob b : blobs)
  {
    b.display();
  }
}

/*=====================================
 Populate the array of blobs.
 You can use any values for radius, number of sides
 and wobble factor that you'd like, but you must
 use x and y coordinates that ensure the blobs
 are drawn in a grid without overlaping each other.
 
 Your code should work for any reasonable value
 of population (i.e. something that would fit on a
 normal monitor).
 ====================================*/
void populate() {
  blobs = new Blob[popSize];
  int i = 0;
  for(int r = 0; r < h; r++)
  {
    while(i < popSize && i - r * w < w)
    {
      int x = 75 + 150 * (i - r  * w);
      int y = r * 150 + 75;
      int sides = (int)(random(10) + 3);
      int rad = 50 + (int)(random(21));
      int wobble = 3 + (int)(random(8));
      blobs[i] = new Blob(x, y, sides, rad, wobble, wobble);
      i++;
    }
  } 
}

