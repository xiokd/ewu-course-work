/*
Name: Keng Xiong
Compiler: g++
*/

#pragma once
#ifndef RAY_H
#define RAY_H
#include <iostream>
#include "Point3D.h"
#include "Sphere.h"

class Ray {
    Point3D o, d;
public:
    Ray(); //Default Constructor
    Ray(Point3D, Point3D); //Constructor with Parameters
    Point3D getOrigin() const;
    Point3D getDirection() const;
    Ray& setOrigin(Point3D);
    Ray& setDirection(Point3D);
    void checkIntersection(const Sphere&);
};

#endif //RAY_H
