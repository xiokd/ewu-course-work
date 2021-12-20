#include <stdio.h>
int(*pFcn)(int, int);
int Add(int a, int b);
int Subtract(int a, int b);
int Multiply(int a, int b);
int Divide(int a, int b);

int main() {
  int X, Y, operation;
  printf("Enter a number: ");
  scanf("%d", &X);

  printf("Enter another number: ");
  scanf("%d", &Y);

  printf("Enter an operation (0=add, 1=subtract, 2=mulitply, 3=divide): ");
  scanf("%d", &operation);

  switch(operation) {
    case 0: pFcn = Add; break;
    case 1: pFcn = Subtract; break;
    case 2: pFcn = Multiply; break;
    case 3: pFcn = Divide; break;
  }

  printf("The answer is: %d\n", pFcn(X, Y));

  return 0;
}

int Add(int a, int b) {
  int sum = a + b;
  return sum;
}

int Subtract(int a, int b) {
  int difference = a - b;
  return difference;
}

int Multiply(int a, int b) {
  int product = a * b;
  return product;
}

int Divide(int a, int b) {
  int quotient = a / b;
  return quotient;
}
