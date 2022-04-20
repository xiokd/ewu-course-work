#include <stdio.h>
int main() {
  short sInt = 5;
  int oInt = 20;
  char cVar = 'Z';
  long lInt = 35;
  long double lDouble = 45.5;

  printf("%d\n", sizeof(short) < sizeof(int));
  printf("%d\n", sizeof(char) < sizeof(short));
  printf("%d\n", sizeof(long) > sizeof(int));
  printf("%d\n", sizeof(long double) > sizeof(double));

  return 0;
}
