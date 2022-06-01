/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "Shape2D.h"

class Triangle : public Shape2D {
protected:
    double width, height;
public:
    Triangle(std::string _name, double _width, double _height) : Shape2D{_name}, width{_width}, height{_height}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", width: " << width << ", height: " << height << ", area: " << computeArea() << std::endl;}
    double computeArea() const {return ((width * height) / 2);}
};

#endif //TRIANGLE_H
