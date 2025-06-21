import java.util.Stack;

class Torre {
  Stack<Disco> discos;
  float x, y;
  int ind;

  Torre(Stack<Disco> discos, float x, float y, int ind) {
    this.discos = discos;
    this.x = x;
    this.y = y;
    this.ind = ind;
  }

  void desenha() {
    fill(#150202);
    rectMode(CENTER);

    // Desenha o pilar da torre
    rect(x, y - 125, 20, 250);  // altura de 250 px, centralizado

    // Desenha os discos empilhados
    float alturaAcumulada = 0;
    for (int i = 0; i < discos.size(); i++) {
      Disco d = discos.get(i);
      float discoY = y - d.get_altura() / 2 - alturaAcumulada;
      d.desenhar(x, discoY);
      alturaAcumulada += d.get_altura();
    }
  }
}
