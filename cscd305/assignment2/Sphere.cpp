/*
Name: Keng Xiong
Compiler: g++
*/

#include "Sphere.h"

Sphere::Sphere() : c{Point3D()}, r{0}{}

Sphere::Sphere(Point3D center, double radius) : c{center}, r{radius}{}

Point3D Sphere::getCenter() const {
    return this->c;
}

double Sphere::getRadius() const {
    return r;
}

Sphere& Sphere::setCenter(Point3D center) {
    this->c = center;
    return (*this);
}

Sphere& Sphere::setRadius(double radius) {
    this->r = radius;
    return (*this);
}
