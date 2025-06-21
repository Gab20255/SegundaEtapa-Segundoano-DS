class BolaBasquete {
  float velocidadey; //Velocidade da Bola
  float aceleracaoy; //Aceleração que alterará a velocidade da Bola
  float tamanho; //Tamanho fixo
  float posx; //Posições que serãõ determinadas pelo usuário através do mouse
  float posy;
  
  BolaBasquete(float posx, float posy){
    this.posx = posx;
    this.posy = posy;
    tamanho = 50;
    aceleracaoy = 0.1;
    velocidadey = 0;
  }

  void show(){
    fill(#FF8400);
    pushMatrix(); 
    translate(posx, posy);
    image(img1, 0,-tamanho/2, tamanho, tamanho);
    popMatrix();
  }

  void update(){
    velocidadey += aceleracaoy;
    posy += velocidadey;

    if (posy >= height - tamanho/2) {
      velocidadey *= -0.9;
      posy = height - tamanho/2;
    }
  }
}
