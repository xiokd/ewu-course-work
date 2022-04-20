#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Person readData();
void printData();

struct Person {
  char name[BUFSIZ];
  char ssn[BUFSIZ];
  int age;
  float height;
  float weight;
};

int main() {
	struct Person person;
	printf("Reading data ......\n");
	person = readData();

  printf("\n");

  printf("Printing data ....\n");
	printData(person);

	return 0;
}

struct Person readData() {
	struct Person person;
	char buff[BUFSIZ];

	fgets(buff, BUFSIZ, stdin);
	buff[strlen(buff) - 1] = '\0';
	strcpy(person.name, buff);

	fgets(buff, BUFSIZ, stdin);
	buff[strlen(buff) - 1] = '\0';
	strcpy(person.ssn, buff);

	fgets(buff, BUFSIZ, stdin);
	person.age = atoi(buff);

	fgets(buff, BUFSIZ, stdin);
	person.height = atof(buff);

	fgets(buff, BUFSIZ, stdin);
	person.weight = atof(buff);

	return person;
}

void printData(struct Person person) {
	printf("%s\n%s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", person.name
	, person.ssn, person.age, person.height, person.weight);
}
