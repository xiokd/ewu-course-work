/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape2D.h"

class Circle : public Shape2D {
protected:
    double radius;
public:
    Circle(std::string _name, double _radius) : Shape2D{_name}, radius{_radius}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", radius: " << radius << ", area: " << computeArea() << std::endl;}
    double computeArea() const {return (PI * (pow(radius, 2)));}
};

#endif //RECTANGLE_H
