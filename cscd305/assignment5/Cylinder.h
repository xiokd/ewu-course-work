/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef CYLINDER_H
#define CYLINDER_H

#include "Shape3D.h"

class Cylinder : public Shape3D {
protected:
    double radius, height;
public:
    Cylinder(std::string _name, double _radius, double _height) : Shape3D{_name}, radius{_radius}, height{_height}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", radius: " << radius << ", height: " << height <<", area: " << computeArea() << ", volume: " << computeVolume() << std::endl;}
    double computeArea() const {return ((2.0 * (PI * radius)) * (height + radius));}
    double computeVolume() const {return (height * (PI * (pow(radius, 2))));}
};

#endif //CYLINDER_H
