/*
Name: Keng Xiong
Compiler: g++
*/

#include <iostream>
#include "Node.h"
#include "Node.cpp"

void createDoublyLinkedList();

int main() {

    createDoublyLinkedList();

    return 0;
}

void createDoublyLinkedList() {
    shared_ptr<Node<string>> start;
    shared_ptr<Node<string>> end;
    shared_ptr<Node<string>> nd(new Node<string>("Tom"));

    start = nd;
    end = start;

    shared_ptr<Node<string>> nd1(new Node<string>("Dick"));

    nd1->setPrevious(end);
    end->setNext(nd1);
    end = nd1;


    shared_ptr<Node<string>> nd2(new Node<string>("Harry")) ;

    nd2->setPrevious(end);
    end->setNext(nd2);
    end = nd2;

    PrintForward(start);
    PrintReverse(end);

/*
    Commented out deleteList method due to smart pointer implementation not 
    needing to explicitly delete nodes using the method. Nodes are deleted 
    automatically as they go out of scope while using smart pointer implementation.
*/

    //deleteList(start);

}