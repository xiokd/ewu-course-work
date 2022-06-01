/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef SHAPE2D_H
#define SHAPE2D_H

#include "Shape.h"

class Shape2D : public Shape {

public:
    Shape2D(std::string _name) : Shape{_name}{}
    virtual void printDetail() const {std::cout << name << ", " << getType() << std::endl;}
    virtual std::string getType() const {return "2D Shape";}
    virtual double computeArea() const = 0;
};

#endif //SHAPE2D_H
