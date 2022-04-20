#include "LinkedListString.h"

int main() {
  struct node* head = NULL;

  push(&head, "Tom");
  push(&head, "Dick");
  push(&head, "Harry");
  push(&head, "Paul");
  push(&head, "Chris");
  push(&head, "Stuart");
  push(&head, "Rob");
  push(&head, "Harry");
  push(&head, "Harry");

  printf("Linked list after insertion: \n");
  printList(head);
  printf("\n");

  printf("Number of elements in the list: %d\n", listCount(head));
  printf("\n");

  deleteElement(&head, "Harry");
  printf("Linked list after deletion: \n");
  printList(head);
  printf("\n");
  printf("Number of elements in the list after deletion: %d\n", listCount(head));
  printf("\n");

  reverseList(&head);
  printf("Reversed Linked list \n");
  printList(head);
  printf("\n");

  listAllDelete(&head);
  printf("Number of elements in the list after deletion: %d\n", listCount(head));
  printf("\n");

  return 0;
}
