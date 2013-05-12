class rain 
{

  PVector first, second, velocity, start;
 int laenge;
 int versatz;            //Damit nicht alle Tropfen oben "kleben"
 float lu, la, angle;
   rain() 
   {
    start = new PVector((int)random(1000), (int)random(400));
    angle = random(0.3);
    laenge = (int)random(5, 12);
    first = new PVector(start.x, start.y);
    lu = sin(-angle) * laenge;
    la = cos(-angle) * laenge;
    second = new PVector(first.x + lu, first.y + la);
    velocity = new PVector(lu * random(3, 5), la * random(3, 5));
   }
   
   void update() 
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
 
   void display()
   {
    line(first.x, first.y, second.x, second.y);
    first.add(velocity);
    second.add(velocity);
   }
   
   void attraktor() 
   {
    if(mousePressed)
     {
      
     } 
   }
}
