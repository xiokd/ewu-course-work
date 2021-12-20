#include <stdio.h>
int main() {
  int a = 3;
  int b = 4;
  double c = ++a + b++;
  size_t size = sizeof(c/a);

  printf("%d\n", a);
  printf("%d\n", b);
  printf("%f\n", c);
  printf("%zu\n", size);

  return 0;
}
