import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Moving_Painting extends PApplet {

rain[] regen;
int tropfen = 4000;

public void setup() {
 size(1000, 400);
 
 regen = new rain[tropfen];
 for(int i = 0; i < tropfen; i++) 
 {
  regen[i] = new rain();
 }  
}

public void draw() {
 background(255);
 
 for(int i = 0; i < tropfen; i++) 
 {
  regen[i].update();
  regen[i].display();
 }

 
}
class rain 
{

  PVector first, second, velocity, start;
 int laenge;
 int versatz;            //Damit nicht alle Tropfen oben "kleben"
 float lu, la, angle;
   rain() 
   {
    start = new PVector((int)random(1000), (int)random(400));
    angle = random(0.3f);
    laenge = (int)random(5, 12);
    first = new PVector(start.x, start.y);
    lu = sin(-angle) * laenge;
    la = cos(-angle) * laenge;
    second = new PVector(first.x + lu, first.y + la);
    velocity = new PVector(lu * random(3, 5), la * random(3, 5));
   }
   
   public void update() 
   {
    if(second.x < 0)               //check if the drop is too far left
    {
     first.x = random(1000);
     versatz = (int)random(-20);
     first.y = 0 + versatz;
     second.x = first.x + lu;
     second.y = first.y + la;
    }  
    
    if(second.y > 400)              //check if drop is too far below
    {
     first.x = random(1020);
     versatz = (int)random(-20);
     first.y = 0 + versatz;
     second.x = first.x + lu;
     second.y = first.y + la;
    }
   }
 
   public void display()
   {
    line(first.x, first.y, second.x, second.y);
    first.add(velocity);
    second.add(velocity);
   }
   
   public void attraktor() 
   {
    if(mousePressed)
     {
      
     } 
   }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Moving_Painting" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
