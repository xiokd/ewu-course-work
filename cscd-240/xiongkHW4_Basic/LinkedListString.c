#include "LinkedListString.h"

void push(struct node** head_ref, char* new_data) {
  struct node* new_node = malloc(sizeof(struct node));
  strcpy(new_node->data, new_data);
  new_node->next = (*head_ref);
  (*head_ref) = new_node;
}

void printList(struct node *head) {
  struct node *temp = head;

  while (temp != NULL) {
    printf("%s  ", temp->data);
    temp = temp->next;
  }
}

int listCount(struct node *head) {
  int count = 0;
  struct node *temp = head;

  while(temp != NULL) {
    count++;
    temp = temp->next;
  }
  return count;
}

void reverseList(struct node** head_ref) {
  struct node* cur = *head_ref;
  struct node* prev = NULL;
  struct node* next;

  while(cur != NULL) {
    next = cur->next;
    cur->next = prev;
    prev = cur;
    cur = next;
  }
  *head_ref = prev;
}

void listAllDelete(struct node **currP) {
  struct node* temp = *currP;

  while(temp != NULL) {
    *currP = (*currP)->next;
    free(temp);
    temp = (*currP);
  }
}

void deleteElement(struct node **currP, char *value) {
  struct node* temp = *currP;

  while(temp != NULL && (strcmp(temp->data, value) == 0)) {
    *currP = (*currP)->next;
    free(temp);
    temp = *currP;
  }

  struct node* prev;

  while(temp != NULL) {
    while(temp != NULL && (strcmp(temp->data, value) != 0)) {
      prev = temp;
      temp = temp->next;
    }

    if(temp == NULL) {
      return;
    }

    prev->next = temp->next;
    free(temp);
    temp = prev->next;
  }
}
