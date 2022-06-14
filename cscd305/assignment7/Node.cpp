/*
Name: Keng Xiong
Compiler: g++
*/

#include "Node.h"

template <class T>
T Node<T>::getValue()
{
    return Value;
}

template <class T>

shared_ptr<Node<T>> Node<T>::getNext()
{
    return next;
}

template <class T>
void Node<T>::setNext(shared_ptr<Node<T>> nextPtr)
{
    next = nextPtr;
}

template <class T>
weak_ptr<Node<T>> Node<T>::getPrevious()
{
    return prev;
}

template <class T>
void Node<T>::setPrevious(weak_ptr<Node<T>> prevPtr)
{
    prev = prevPtr;
}


template<typename T>
void PrintForward(shared_ptr<Node<T>> start) {
    shared_ptr<Node<T>> temp = start;

    while (temp) {

        cout << temp->getValue() << "-> ";
        temp = temp->getNext();
    }
    cout << endl;
}
template<typename T>
void PrintReverse(shared_ptr<Node<T>> end) {

    weak_ptr<Node<T>> temp = end;
    while (!temp.expired()) {
        cout << "<-" << temp.lock()->getValue() << " ";
        temp = temp.lock()->getPrevious();
    }
    cout << endl;
}

/*
    Commented out deleteList method due to smart pointer implementation not 
    needing to explicitly delete nodes using the method. Nodes are deleted 
    automatically as they go out of scope while using smart pointer implementation.
*/

/*
template <typename T>
void deleteList(shared_ptr<Node<T>> start)
{
    shared_ptr<Node<T>> temp = start;
    while (start) {
        temp = start;
        start = start->getNext();
        delete(temp);
    }
}
*/