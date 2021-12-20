#include <stdio.h>
int main() {
  int i = 0;
  int grade;
  double sum = 0.0;
  double average;

  printf("Please input a number of grades: ");
  scanf("%d", &grade);

  while(grade != -1000) {
    i++;
    sum += grade;
    average = sum/i;

    printf("Sum is: %f\n", sum);
    printf("Average is: %f\n", average);

    scanf("%d", &grade);
  }

  return 0;
}
