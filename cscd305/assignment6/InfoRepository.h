/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef INFOREPOSITORY_H
#define INFOREPOSITORY_H

#include <iomanip>
#include <iostream>
#include <string>
#include "InfoNode.h"

template<typename T, typename U, typename V>
class InfoRepository {
public:
    InfoRepository(std::string name);
    ~InfoRepository();
    bool isEmpty();
    void printInformation();
    void retrieveInfoNode(const T &t);
    void addInfo(T t, U u, V v);
private:
    InfoNode<T, U, V> *first;
    std::string i_name;
};

template<typename T, typename U, typename V>
InfoRepository<T, U, V>::InfoRepository(std::string name) {
    first = NULL;
    i_name = name;
}

template<typename T, typename U, typename V>
InfoRepository<T, U, V>::~InfoRepository() {
    InfoNode<T, U, V> *current_node = first;
    while(current_node != NULL) {
        first = first->next;
        delete current_node;
        current_node = first;
    }
}

template<typename T, typename U, typename V>
bool InfoRepository<T, U, V>::isEmpty() {
    return (first == NULL);
}

template<typename T, typename U, typename V>
void InfoRepository<T, U, V>::printInformation() {
    std::cout << "Printing " << i_name << " info.....\n" << std::endl;
    InfoNode<T, U, V> *current_node = first;
    while(current_node != NULL) {
        std::cout << std::left << std::setw(20) << std::setfill(' ') << current_node->data_one
                  << std::left << std::setw(35) << std::setfill(' ') << current_node->data_two
                  << std::left << std::setw(25) << std::fixed << std::setprecision(2) << std::setfill(' ')
                  << current_node->data_three << std::endl;

        current_node = current_node->next;
    }
    std::cout << std::endl;
}

template<typename T, typename U, typename V>
void InfoRepository<T, U, V>::addInfo(T t, U u, V v) {
    auto *list_node = new InfoNode<T, U, V>(t, u, v);

    // Implemented by adding from Linked List head
    if(this->isEmpty()) {
        first = list_node;
    } else {
        list_node->next = first;
        first = list_node;
    }
}

template<typename T, typename U, typename V>
void InfoRepository<T, U, V>::retrieveInfoNode(const T &t) {
    std::cout << "Retrieving Node with id " << t << " from the database....." << std::endl;

    InfoNode<T, U, V> *current_node = first;
    bool found = false;

    while(current_node != NULL  && !found) {
        if(current_node->data_one == t) {
            std::cout << "Node with id " << t << " was found in the database.\n" << std::endl;
            std::cout << "Here's the information....." << std::endl;

            std::cout << std::left << std::setw(20) << std::setfill(' ') << current_node->data_one
                      << std::left << std::setw(35) << std::setfill(' ') << current_node->data_two
                      << std::left << std::setw(25) << std::fixed << std::setprecision(2) << std::setfill(' ')
                      << current_node->data_three << "\n" <<std::endl;

            found = true;
        }
        current_node = current_node->next;
    }

    if(!found) {
        std::cout << "No Node with id " << t << " exists in the list." << std::endl;
        std::cout << "Press enter to continue...." << std::endl;
        std::cin.get();
    }
}

#endif //INFOREPOSITORY_H
