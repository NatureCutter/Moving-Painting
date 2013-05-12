rain[] regen;
int tropfen = 4000;

void setup() {
 size(1000, 400);
 
 regen = new rain[tropfen];
 for(int i = 0; i < tropfen; i++) 
 {
  regen[i] = new rain();
 }  
}

void draw() {
 background(255);
 
 for(int i = 0; i < tropfen; i++) 
 {
  regen[i].update();
  regen[i].display();
 }

 
}
