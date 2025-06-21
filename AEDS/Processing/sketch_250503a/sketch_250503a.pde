Peixe[] p = new Peixe[10];  //<>// //<>//
int inter = 0;
float[] x= new float[50];
float[] y= new float[50];
float[] vx= new float[50];
float[] vy= new float[50];
void setup() {
  size(800, 600);
  background(#054EFF); 
  for (int i = 0; i < 10; i++) {
    p[i] = new Peixe();      
  }
  for(int i=0; i< 50;i++){
    x[i]= random(10, width-10); 
    y[i]= height; 
    vx[i]= random(-1,2);
    vy[i]= random(-1,2);
  }
}
void draw() {
  background(#054EFF);
  for (int i = 0; i < 10; i++) {
    p[i].Desenha(); 
    p[i].Move(inter);
  }
  for (int i = 0; i < 50; i++) {
    desenhabolhinhas(x[i], y[i]); 
    y[i]= y[i]-vy[i];
    x[i]= x[i]+vx[i];
    if(y[i]<0){
     y[i]=height; 
    }
    if(x[i]<10 || x[i]>width-10){
      y[i]=height;
      x[i]= random(10, width-10);
    }
  }
  inter++;
}
void desenhabolhinhas(float x, float y){
  pushMatrix();
  fill(255, 255, 255, 100);
  stroke(255);
  strokeWeight(1);
  circle(x, y, 10);
  popMatrix();
}
