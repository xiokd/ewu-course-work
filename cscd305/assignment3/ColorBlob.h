/*
Name: Keng Xiong
Compiler: g++
*/

#pragma once
#ifndef COLORBLOB_H
#define COLORBLOB_H

#include <iostream>
#include "Color.h"

class ColorBlob {
    int height, width;
    Color** data{};
    const int default_size = 2;

public:
    ColorBlob(); // Default Constructor
    ColorBlob(int c_height, int c_width, const Color& color); // Constructor with parameters
    ColorBlob(const ColorBlob& cb); // Copy constructor
    ColorBlob& operator=(const ColorBlob& cb); // Copy assignment constructor
    ~ColorBlob(); // Destructor
    ColorBlob(ColorBlob&& cb); // Move Constructor
    ColorBlob& operator=(ColorBlob&& cb); // Move assignment operator

    // Friend Functions
    friend bool operator==(const ColorBlob& cBlobOne, const ColorBlob& cBlobTwo);
    friend ColorBlob operator+(const ColorBlob& cBlobOne, const ColorBlob& cBlobTwo);
    friend ColorBlob operator-(const ColorBlob& cBlobOne, const ColorBlob& cBlobTwo);
    friend ColorBlob operator*(const ColorBlob& cBlobOne, const Color& c);
    friend bool operator!(const ColorBlob& cBlobOne);
    friend std::ostream& operator<<(std::ostream& o_str, const ColorBlob& cb);
    friend std::istream& operator>>(std::istream& i_str, ColorBlob& cb);
};


#endif //COLORBLOB_H
