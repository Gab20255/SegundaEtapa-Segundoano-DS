void mergeSort(Individuo[] arr, int inicio, int fim) {
  if (inicio < fim) {
    int meio = (inicio + fim) / 2;
    mergeSort(arr, inicio, meio);
    mergeSort(arr, meio + 1, fim);
    merge(arr, inicio, meio, fim);
  }
}
void merge(Individuo[] arr, int inicio, int meio, int fim) {
  int n1 = meio - inicio + 1;
  int n2 = fim - meio;

  Individuo[] esquerda = new Individuo[n1];
  Individuo[] direita = new Individuo[n2];

  for (int i = 0; i < n1; i++) esquerda[i] = arr[inicio + i];
  for (int j = 0; j < n2; j++) direita[j] = arr[meio + 1 + j];

  int i = 0, j = 0, k = inicio;
  
while (i < n1 && j < n2) {
    if (esquerda[i].quantosInfectou >= direita[j].quantosInfectou) {
      arr[k] = esquerda[i];
      i++;
    } else {
      arr[k] = direita[j];
      j++;
    }
    k++;
  }
