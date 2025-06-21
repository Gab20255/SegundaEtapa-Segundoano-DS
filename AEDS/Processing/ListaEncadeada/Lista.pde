class Lista {
  No cabeca;

  void Adiciona(int x) {
    if (cabeca == null) {
      cabeca = new No(x);
    } else {
      No atual = cabeca;
      while (atual.proximo != null) atual = atual.proximo;
      atual.proximo = new No(x);
    }
  }

  void Remove(int x) {
    if (cabeca == null) return;

    No atual = cabeca;
    No anterior = null;

    while (atual != null) {
      if (atual.valor == x) {
        if (atual == cabeca) {
          cabeca = atual.proximo;
          atual = atual.proximo;
        } else {
          anterior.proximo = atual.proximo;
          atual = atual.proximo;
        }
      } else {
        anterior = atual;
        atual = atual.proximo;
      }
    }
  }

  int Contar() {
    if (cabeca == null) return 0;
    No atual = cabeca;
    int con = 0;
    while (atual != null) {
      atual = atual.proximo;
      con++;
    }
    return con;
  }

  void RemoverEm(int pos) {
    if (pos >= Contar()) return;
    if (pos == 0) {
      cabeca = cabeca.proximo;
      return;
    }
    No atual = cabeca;
    No anterior = null;
    while (pos > 0) {
      anterior = atual;
      atual = atual.proximo;
      pos--;
    }
    anterior.proximo = atual.proximo;
  }

  void Print() {
    if (cabeca == null) return;
    No atual = cabeca;
    while (atual != null) {
      println(atual.valor);
      atual = atual.proximo;
    }
  }
}

class No {
  int valor;
  No proximo;

  No(int v) {
    valor = v;
    proximo = null;
  }
}
