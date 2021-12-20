#include <stdio.h>
int main() {
  char name[100];
  
  printf("Please enter a name: ");
  fgets(name, 100, stdin);
  printf("The name you entered is %s", name);

  return 0;
}
