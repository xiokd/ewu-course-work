/*
Name: Keng Xiong
Compiler: g++
*/

#include "Color.h"
#include <iostream>

Color::Color() : red{0.5}, green{0.5}, blue{0.5}{}
Color::Color(double c_red, double c_green, double c_blue) : red{c_red}, green{c_green}, blue{c_blue}{}
Color::Color(const Color& c) : red{c.red}, green{c.green}, blue{c.blue}{}

Color &Color::operator=(const Color &c) {
    red = c.red;
    green = c.green;
    blue = c.blue;

    return *this;
}

double Color::getRed() const {
    return this->red;
}

double Color::getGreen() const {
    return this->green;
}

double Color::getBlue() const {
    return this->blue;
}


void Color::setRed(double c_red) {
    if(c_red > 1.0) { 
        this->red = 1.0;
    } else if (c_red < 0.0) { 
        this->red = 0.0;
    } else { 
        this->red = c_red;
    }
}

void Color::setGreen(double c_green) {
   if(c_green > 1.0) { 
        this->green = 1.0;
    } else if (c_green < 0.0) { 
        this->green = 0.0;
    } else { 
        this->green = c_green;
    }
}

void Color::setBlue(double c_blue) {
    if(c_blue > 1.0) { 
        this->blue = 1.0;
    } else if (c_blue < 0.0) { 
        this->blue = 0.0;
    } else { 
        this->blue = c_blue;
    }
}

bool operator==(const Color& colorOne, const Color& colorTwo) {
    return ((colorOne.getRed() == colorTwo.getRed())
            && (colorOne.getGreen() == colorTwo.getGreen())
            && (colorOne.getBlue() == colorTwo.getBlue()));
}

Color operator+(const Color& colorOne, const Color& colorTwo) {
    double temp_red = colorOne.getRed() + colorTwo.getRed();
    double temp_green = colorOne.getGreen() + colorTwo.getGreen();
    double temp_blue = colorOne.getBlue() + colorTwo.getBlue();

    if(temp_red > 1.0) {
        temp_red = 1.0;
    }

    if(temp_green > 1.0) {
        temp_green = 1.0;
    }

    if(temp_blue > 1.0) {
        temp_blue = 1.0;
    }

    Color color_new(temp_red, temp_green, temp_blue);

    return color_new;
}

Color operator-(const Color& colorOne, const Color& colorTwo) {
    double temp_red = colorOne.getRed() - colorTwo.getRed();
    double temp_green = colorOne.getGreen() - colorTwo.getGreen();
    double temp_blue = colorOne.getBlue() - colorTwo.getBlue();

    if(temp_red < 0.0) {
        temp_red = 0.0;
    }

    if(temp_green < 0.0) {
        temp_green = 0.0;
    }

    if(temp_blue < 0.0) {
        temp_blue = 0.0;
    }

    Color color_new(temp_red, temp_green, temp_blue);

    return color_new;
}

Color operator*(const Color& colorOne, const Color& colorTwo) {
    double temp_red = colorOne.getRed() * colorTwo.getRed();
    double temp_green = colorOne.getGreen() * colorTwo.getGreen();
    double temp_blue = colorOne.getBlue() * colorTwo.getBlue();

    Color color_new(temp_red, temp_green, temp_blue);

    return color_new;
}

bool operator!(const Color &colorOne) {
    return (colorOne.getRed() != 0.0 && colorOne.getGreen() != 0.0
            && colorOne.getBlue() != 0.0);
}

std::ostream &operator<<(std::ostream& o_str, const Color& c) {
    o_str << "(" << c.red << " " << c.green << " " << c.blue << ")";
    return o_str;
}

std::istream &operator>>(std::istream& i_str, Color& c) {
    i_str >> c.red >> c.green >> c.blue;

    c.setRed(c.red);
    c.setGreen(c.green);
    c.setBlue(c.blue);

    return i_str;
}