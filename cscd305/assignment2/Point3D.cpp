/*
Name: Keng Xiong
Compiler: g++
*/

#include "Point3D.h"

Point3D::Point3D() :x{0},y{0},z{0}{}

Point3D::Point3D(double xP, double yP, double zP) :x{xP},y{yP},z{zP}{}

double Point3D::getX() const {
    return this->x;
}

double Point3D::getY() const {
    return this->y;
}

double Point3D::getZ() const {
    return this->z;
}

Point3D& Point3D::setX(double xP) {
    this->x = xP;
    return (*this);
}

Point3D& Point3D::setY(double yP) {
    this->y = yP;
    return (*this);
}

Point3D& Point3D::setZ(double zP) {
    this->z = zP;
    return (*this);
}

Point3D& Point3D::addPoints(const Point3D& vec) {
    this->x += vec.x;
    this->y += vec.y;
    this->z += vec.z;

    return (*this);
}

Point3D& Point3D::subtractPoints(const Point3D& vec) {
    this->x -= vec.x;
    this->y -= vec.y;
    this->z -= vec.z;

    return (*this);
}

double Point3D::multiplyPoints(const Point3D & vec) {
    double val = (this->x * vec.x) + (this->y * vec.y) + (this->z * vec.z);
    return val;
}

double Point3D::squarePoints() {
    double val = (this->x * this->x) + (this->y * this->y) + (this->z * this->z);
    return val;
}