#include <stdio.h>
int main(){
  int c;
  char dummy[10];

  printf("Enter a value: ");
  c = getchar();
  getchar();

  while(c != 'q' && c != 'Q') {
    printf("You entered: ");
    putchar(c);
    printf("\n");
    printf("Enter a value: ");
    c = getchar();
    getchar();
  }

  return 0;
}
