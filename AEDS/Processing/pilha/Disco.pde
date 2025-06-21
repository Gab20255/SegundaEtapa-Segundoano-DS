class Disco {
  float tamanhoc, tamanhoh;
  color cor;

  Disco() {
    this.tamanhoc = random(100, 150);       // largura do retângulo
    this.tamanhoh = 30;                  
    this.cor = color(random(255), random(255), random(255));
  }

  void desenha(float posx, float posy) {
    fill(cor);
    noStroke();
    pushMatrix();
    translate(posx, posy);
    rectMode(CENTER); // Desenha o retângulo a partir do centro
    rect(0, 0, tamanhoc, tamanhoh);
    popMatrix();
  }
}
