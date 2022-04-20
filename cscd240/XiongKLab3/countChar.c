#include <stdio.h>
#include <ctype.h>
#define MAXSIZE 100

int main() {
  char ch;
  int i;
  char sentence[MAXSIZE];
  int alphabetsCount = 0;

  printf("Type a sentence: ");
  fgets(sentence, MAXSIZE, stdin);

  printf("Type a character that you'd like to find the number of occurrences in a sentence: ");
  scanf("%c", &ch);

  for(i = 0; sentence[i] != '\n'; i++) {
    if(sentence[i] == tolower(ch) || sentence[i] == toupper(ch)) {
      alphabetsCount++;
    }
  }

  printf("Alphabet %c has a frequency of %d\n", ch, alphabetsCount);

  return 0;
}
