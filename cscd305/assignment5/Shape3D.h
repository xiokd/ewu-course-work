/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef SHAPE3D_H
#define SHAPE3D_H

#include "Shape2D.h"

class Shape3D : public Shape2D {

public:
    Shape3D(std::string _name) : Shape2D{_name}{}
    virtual void printDetail() const {std::cout << name << ", " << getType() << std::endl;}
    virtual std::string getType() const {return "3D Shape";}
    virtual double computeVolume() const = 0;
};

#endif //SHAPE3D_H
