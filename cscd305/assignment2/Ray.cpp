/*
Name: Keng Xiong
Compiler: g++
*/

#include "Ray.h"
#include "Sphere.h"

Ray::Ray() :o{Point3D()}, d{Point3D()}{}

Ray::Ray(Point3D origin, Point3D direction) :o{origin}, d{direction}{}

Point3D Ray::getOrigin() const {
    return this->o;
}

Point3D Ray::getDirection() const {
    return this->d;
}

Ray &Ray::setOrigin(Point3D origin) {
    this->o = origin;
    return (*this);
}

Ray &Ray::setDirection(Point3D direction) {
    this->d = direction;
    return (*this);
}

void Ray::checkIntersection(const Sphere& sphere) {
    double A = d.squarePoints(); //d^2

    Point3D origin_sub_center = o.subtractPoints(sphere.getCenter()); //(o-c)
    double B = d.multiplyPoints(origin_sub_center); //(o-c)*d

    double radius_squared = sphere.getRadius() * sphere.getRadius();
    double C = origin_sub_center.squarePoints() - radius_squared; //(o-c)^2 - r^2

    double calculated_value = (B * B) - (A * C); //B^2 - AC

    if(calculated_value < 0) {
        std::cout << "Ray does not touch or intersect with sphere." << std::endl;
    }
    else {
        std::cout << "Ray either touches or intersects with sphere." << std::endl;
    }
}
