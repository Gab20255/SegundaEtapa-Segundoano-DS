

// Executar o código aqui
Lista list = new Lista();

void setup() {
  list.Adiciona(10);
  list.Adiciona(20);
  list.Adiciona(30);
  list.Print(); // Deve imprimir: 10, 20, 30

  println("---");
  list.Remove(20);
  list.Print(); // Deve imprimir: 10, 30

  println("---");
  list.RemoverEm(0);
  list.Print(); // Deve imprimir: 30
}
