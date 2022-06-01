/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef SHAPE_H
#define SHAPE_H

#include <cmath>
#include <iostream>
#include <string>

class Shape {
protected:
    std::string name;
public:
    Shape(const std::string _name) : name{_name}{};
    const double PI = 3.14159265358979;
    virtual void printDetail() const = 0;
    virtual std::string getType() const = 0;
};

#endif //SHAPE_H
