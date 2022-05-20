/*
Name: Keng Xiong
Compiler: g++
*/

#pragma once
#ifndef POINT3D_H
#define POINT3D_H
#include <iostream>

class Point3D {
    double x, y, z;
public:
    Point3D(); //Default Constructor
    Point3D(double, double, double); //Constructor with Parameters
    double getX() const;
    double getY() const;
    double getZ() const;
    Point3D& setX(double);
    Point3D& setY(double);
    Point3D& setZ(double);
    Point3D& addPoints(const Point3D&);
    Point3D& subtractPoints(const Point3D&);
    double multiplyPoints(const Point3D&);
    double squarePoints();
};

#endif //POINT3D_H
