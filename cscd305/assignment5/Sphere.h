/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef SPHERE_H
#define SPHERE_H

#include "Shape3D.h"

class Sphere : public Shape3D {
protected:
    double radius;
public:
    Sphere(std::string _name, double _radius) : Shape3D{_name}, radius{_radius}{}
    void printDetail() const {std::cout << name << ", " << getType() << ", radius: " << radius <<", area: " << computeArea() << ", volume: " << computeVolume() << std::endl;}
    double computeArea() const {return (4.0 * (PI * (pow(radius, 2))));}
    double computeVolume() const {return ((4.0 / 3.0) * (PI * (pow(radius, 3))));}
};

#endif //SPHERE_H
