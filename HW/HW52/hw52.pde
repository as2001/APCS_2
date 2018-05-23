//  Andrew Shao
//  APCS2 pd2
//  HW52 -- Grow & Shrink
//  2018-05-23W

boolean ready = false; // indicates when to draw
boolean growing = true; // indicates if growing
float r = 50; // raduis of circle

void setup() 
{
  size( 500, 500 ); // size of background
  background( 0 ); // black
}

void draw() 
{
  if ( ready ) {
    ellipse( 250, 250, r, r ); // draws circle
    if ( growing ) r --;
    else r ++; // updates radius
  }
}

void mouseClicked()
{
  ready = true;
  growing = !growing; // alternates
  fill( color( 0, 128, 255 ) ); // light blue
  draw();
}
