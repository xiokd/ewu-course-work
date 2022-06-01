/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef BOX_H
#define BOX_H

#include "Shape3D.h"

class Box : public Shape3D {
protected:
    double width, height, depth;
public:
    Box(std::string _name, double _width, double _height, double _depth) : Shape3D{_name}, width{_width}, height{_height}, depth{_depth}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", width: " << width << ", height: " << height << ", depth: " << depth <<", area: " << computeArea() << ", volume: " << computeVolume() << std::endl;}
    double computeArea() const {return ((2.0 * (width * height)) + (2.0 * (width * depth)) + (2.0 * (height * depth)));}
    double computeVolume() const {return ((width * height) * depth);}
};

#endif //BOX_H
