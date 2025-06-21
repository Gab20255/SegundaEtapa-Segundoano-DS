import java.util.LinkedList;
LinkedList<BolaBasquete> bolas = new LinkedList<BolaBasquete>();
PImage img1;
PImage img2;
void setup() {
  size(626, 351);
  img1 = loadImage("d873ceae-bff5-4cb9-8c67-b20ee6f182fb-removebg-preview.png");
  img2 = loadImage("60bc9bc4064d0036ed325cfe30e1de21.jpg");
}

void draw() {
  background(img2);
  for (BolaBasquete bola : bolas) {
    bola.update();
    bola.show();
  }
}

void mousePressed() {
  bolas.add(new BolaBasquete(mouseX, mouseY));
}
