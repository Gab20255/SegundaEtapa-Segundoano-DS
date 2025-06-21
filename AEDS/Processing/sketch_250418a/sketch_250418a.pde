int[] array = new int[10];
int n = 10;
int i = -1, j = -1, minIdx = -1;

void setup() {
  size(800, 600);
  background(0);

  for (int k = 0; k < array.length; k++) {
    array[k] = (int) random(height);
  }
}

void draw() {
  background(220);
  int l = width / n;

  for (int k = 0; k < n; k++) {
    int h = int(array[k]);
    if (k == i || k == j || k == minIdx) fill(100, 250, 100); 
    else fill(100, 100, 250); // azul

    rect(k * l, height - h, l, h);
  }
}

void mousePressed() {
  for (int k = 0; k < array.length; k++) {
    array[k] = (int) random(height);
  }
  thread("shell_sort");
}
void shell_sort() {
  int h = 1;
  int temp;
  n = array.length;
  while (h < n / 3) {
    h = 3 * h + 1;
  }
  while (h >= 1) {
    for (int i = h; i < n; i++) {
      temp = array[i];
      j = i;
      while (j >= h && array[j - h] > temp) {
        array[j] = array[j - h];
        j = j - h; 
        delay(200);
      }
      array[j] = temp;
      delay(200);
    }
    h = h / 3;
  }
  i = j = minIdx = -1; 
}
