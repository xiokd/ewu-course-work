/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape2D.h"

class Rectangle : public Shape2D {
protected:
    double width, height;
public:
    Rectangle(std::string _name, double _width, double _height) : Shape2D{_name}, width{_width}, height{_height}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", width: " << width << ", height: " << height << ", area: " << computeArea() << std::endl;}
    double computeArea() const {return (width * height);}
};

#endif //RECTANGLE_H
