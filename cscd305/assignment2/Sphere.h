/*
Name: Keng Xiong
Compiler: g++
*/

#pragma once
#ifndef SPHERE_H
#define SPHERE_H
#include <iostream>
#include "Point3D.h"

class Sphere {
    Point3D c;
    double r;
public:
    Sphere(); //Default Constructor
    Sphere(Point3D, double); //Constructor with Parameters
    Point3D getCenter() const;
    double getRadius() const;
    Sphere& setCenter(Point3D);
    Sphere& setRadius(double);
    friend class Ray;
};
#endif //SPHERE_H
