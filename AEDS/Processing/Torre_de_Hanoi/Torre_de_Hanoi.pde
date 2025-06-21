import java.util.Stack;

Torre[] torres = new Torre[3];
int alturaBase = 350;  // Base das torres

void setup() {
  size(700, 400);

  // Criar 3 torres com posições fixas
  for (int i = 0; i < 3; i++) {
    torres[i] = new Torre(new Stack<Disco>(), 150 + i * 200, alturaBase, i);
  }

  // Adicionar 5 discos na primeira torre (torres[0])
  for (int i = 0; i < 5; i++) {
    torres[0].discos.push(new Disco());
  }
}

void draw() {
  background(255);
  for (Torre t : torres) {
    t.desenha();
  }
}
