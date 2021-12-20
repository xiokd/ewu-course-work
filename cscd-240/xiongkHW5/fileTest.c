#include "fileTest.h"

int countString(const char* fileName, char *str){
  int word_count = 0;
  char buff[100];

  FILE* file = fopen(fileName, "r");
  if(file == NULL) {
    perror("Error in opening the file");
    exit(0);
  }

  convertToLower(str);

  while(fscanf(file, "%s", buff) != -1) {
    convertToLower(buff);
    if(strstr(buff, str) != NULL) {
      word_count++;
    }
  }

  return word_count;
}

int countEmptyLines(const char *fileName){
  int emptyLine = 0;
  char buff[BUFSIZ];
  int i, len;

  FILE* file = fopen(fileName, "r");

  if(file == NULL) {
    perror("Error in opening file");
    exit(0);
  }

  while(fgets(buff, sizeof(buff), file) != NULL) {
    emptyLine++;
    len = strlen(buff);

    for(i = 0; i < len; i++) {
      if(buff[i] != '\n' && buff[i] != '\t' && buff[i] != ' ') {
        emptyLine--;
        break;
      }
    }
  }

  return emptyLine;
}

void convertToLower(char* str) {
  int i, len;
  len = strlen(str);
  for(i = 0; i < len; i++) {
    str[i] = tolower(str[i]);
  }
}
