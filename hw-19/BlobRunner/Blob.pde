/*=====================================
  A Blob object is a regular polygon variant that
  can have various features.
  Instance Variables:
    numSides: number of sides
    rad: distance from the center of the polygon
      to any vertext
    x: x coordinate of the center
    y: y coordinate of the center
    xFactor: "wobble" foctor in the x direction
    yFactor: "wobble" factor in the y direction
  ====================================*/

class Blob {
  
  int numSides;
  int rad;
  float x;
  float y;
  int xFactor;
  int yFactor;
  
  Blob(float cx, float cy, int sides, int r, int xf, int yf ) {
    
    x = cx;
    y = cy;
    numSides = sides;
    rad = r;
    xFactor = xf;
    yFactor = yf;
  }

  void display() {
   
    float nx;
    float ny;
    int rx, ry;
    
    float sy;
  
    strokeWeight(1);
    beginShape();
    for( float t = 0; t <= 1; t+=( 1.0/numSides ) ) {
      
      /*
      "wobble" effect is created by adding a random number to each
      x and y coordinate. The larger the x and y factors, the higher
      the possible wobble value could be
      */
      rx = (int)random(xFactor);
      ry = (int)random(yFactor);
      
      nx = rad * cos( 2 * PI * t ) + x + rx;
      ny = rad * sin( 2 * PI * t ) + y + ry;
      
      vertex(nx, ny);
    }      
    endShape();
  }
}
