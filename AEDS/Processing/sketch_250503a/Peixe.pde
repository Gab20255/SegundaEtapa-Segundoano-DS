class Peixe {
  color cor;
  int posx, posy;
  int velocidadex, velocidadey;
  float tamanhoeli;
  float tamanhotri;

  Peixe() {
    cor = color(random(255), random(255), random(255));
    posx = (int)random(60,width-60);   
    posy = (int)random(60,height-60);
    velocidadex = (int)random(-2, 2);   
    velocidadey = (int)random(-2, 2);
    while (velocidadex == 0 || velocidadey == 0) {
      velocidadex = (int)random(-2, 2);   
      velocidadey = (int)random(-2, 2);
    }
    tamanhoeli = random(25, 50);
    tamanhotri = random(15, 25);
  }

  void Desenha() {
    fill(cor);
    pushMatrix(); 
    translate(posx, posy);
    float a = atan2(velocidadey, velocidadex);
    rotate(a);
    ellipse(0, 0, tamanhoeli, tamanhoeli/2); 
    triangle(-tamanhoeli/2, 0, -tamanhoeli/2 - tamanhotri/2, tamanhotri, -tamanhoeli/2 - tamanhotri/2, -tamanhotri);
    fill(255);
    ellipse(tamanhoeli/4, 0, tamanhoeli/8, tamanhoeli/8);
    popMatrix();
  }

  void Move(int inter) {
    posx = posx + velocidadex;
    posy = posy + velocidadey;
    
    if (posx + tamanhoeli/2 > width || posx - tamanhoeli/2 < 0) {
      velocidadex = -velocidadex;
    }
    
    if (posy + tamanhoeli/2 > height || posy - tamanhoeli/2 < 0) {
      velocidadey = -velocidadey;
    }
    
    if (inter == 600) {
      while (velocidadex == 0 || velocidadey == 0) {
      velocidadex = (int)random(-2, 2);   
      velocidadey = (int)random(-2, 2);
    }
    }
  }
}
