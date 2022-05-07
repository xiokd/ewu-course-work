/*
Name: Keng Xiong
Compiler: g++
*/

#pragma once
#ifndef COLOR_H
#define COLOR_H

#include <iostream>

class Color {
    double red, green, blue;
public:
    Color(); // Default constructor
    Color(double red, double green, double blue); // Constructor with parameters
    Color(const Color& c); // Copy constructor
    Color& operator=(const Color& c); // Copy assignment constructor
    double getRed() const;
    double getGreen() const;
    double getBlue() const;
    void setRed(double red);
    void setGreen(double green);
    void setBlue(double blue);

    // Friend functions
    friend bool operator==(const Color& colorOne, const Color& colorTwo);
    friend Color operator+(const Color& colorOne, const Color& colorTwo);
    friend Color operator-(const Color& colorOne, const Color& colorTwo);
    friend Color operator*(const Color& colorOne, const Color& colorTwo);
    friend bool operator!(const Color& colorOne);
    friend std::ostream& operator<<(std::ostream& o_str, const Color& c);
    friend std::istream& operator>>(std::istream& i_str, Color& c);
};


#endif //COLOR_H
