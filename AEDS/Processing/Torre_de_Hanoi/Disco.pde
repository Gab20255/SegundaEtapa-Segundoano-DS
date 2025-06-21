class Disco{
 float largura;
 float altura;
 color cor;
 
 Disco(){
   this.largura=random(60,100);
   this.altura=30;
   this.cor=cor = color(random(255), random(255), random(255));
 }
 void desenhar(float posx, float posy){
    fill(cor);
    pushMatrix(); 
    translate(posx, posy);
    rect(0, 0, largura, altura); 
    popMatrix();
 }
 float get_altura(){
   return this.altura;
 }
}
