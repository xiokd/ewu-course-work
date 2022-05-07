/*
Name: Keng Xiong
Compiler: g++
*/

#include "ColorBlob.h"
#include "Color.h"

ColorBlob::ColorBlob() {
    height = default_size;
    width = default_size;
    
    // Initialization of 2D dynamically allocated array
    data = new Color*[default_size];
    for(int i = 0; i < default_size; i++) {
        data[i] = new Color[default_size];
    }

    // Filling the dynamically allocated array with default colors
    for(int i = 0; i < default_size; i++) {
        for(int j = 0; j < default_size; j++) {
            data[i][j] = Color();
        }
    }
}

ColorBlob::ColorBlob(int c_height, int c_width, const Color& color) {
    height = c_height;
    width = c_width;

    // Initialization of 2D dynamically allocated array
    data = new Color*[height];
    for(int i = 0; i < height; i++) {
        data[i] = new Color[width];
    }

    // Filling the dynamically allocated array with default colors
    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            data[i][j] = color;
        }
    }
}

ColorBlob::ColorBlob(const ColorBlob& cb) : height{cb.height}, width{cb.width} {
    // Initialization of 2D dynamically allocated array
    data = new Color*[cb.height];
    for(int i = 0; i < cb.width; i++) {
        data[i] = new Color[width];
    }

    for(int i = 0; i < cb.height; i++) {
        for(int j = 0; j < cb.width; j++) {
            data[i][j] = cb.data[i][j];
        }
    }
}

ColorBlob &ColorBlob::operator=(const ColorBlob &cb) {
    if(this != &cb) {
        delete[] data;
        height = cb.height;
        width = cb.width;

        // Initialization of 2D dynamically allocated array
        data = new Color*[height];
        for(int i = 0; i < height; i++) {
            data[i] = new Color[width];
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                data[i][j] = cb.data[i][j];
            }
        }
    }

    return *this;
}

ColorBlob::~ColorBlob() {
    if(data != nullptr) {
        for(int i = 0; i < height; i++) {
            delete[] data[i];
            data[i] = nullptr;
        }
        delete[] data;
        data = nullptr;
        height = 0;
        width = 0;
    }
}

ColorBlob::ColorBlob(ColorBlob &&cb) {
    height = cb.height;
    width = cb.width;
    data = cb.data;

    cb.height = 0;
    cb.width = 0;
    cb.data = nullptr;
}

ColorBlob &ColorBlob::operator=(ColorBlob &&cb) {
    if(this != &cb) {
        delete[] data;
        height = 0;
        width = 0;

        height = cb.height;
        width = cb.width;
        data = cb.data;

        cb.height = 0;
        cb.width = 0;
        cb.data = nullptr;

    }
    return *this;
}

bool operator==(const ColorBlob &cBlobOne, const ColorBlob &cBlobTwo) {
    if((cBlobOne.height != cBlobTwo.height) && (cBlobOne.width != cBlobTwo.width)) { return false;}
    for(int i = 0; i < cBlobOne.height ; i++) {
        for(int j = 0; j < cBlobOne.width; j++) {
            if(!(cBlobOne.data[i][j] == cBlobTwo.data[i][j])) { return false;} // Returns false if they are not equal
        }
    }

    return true;
}

ColorBlob operator+(const ColorBlob &cBlobOne, const ColorBlob &cBlobTwo) {
    ColorBlob cb(cBlobOne.height, cBlobOne.width, Color());
    for(int i = 0; i < cBlobOne.height ; i++) {
        for(int j = 0; j < cBlobOne.width; j++) {
            cb.data[i][j] = cBlobOne.data[i][j] + cBlobTwo.data[i][j];
        }
    }

    return cb;
}

ColorBlob operator-(const ColorBlob &cBlobOne, const ColorBlob &cBlobTwo) {
    ColorBlob cb(cBlobOne.height, cBlobOne.width, Color());
    for(int i = 0; i < cBlobOne.height ; i++) {
        for(int j = 0; j < cBlobOne.width; j++) {
            cb.data[i][j] = cBlobOne.data[i][j] - cBlobTwo.data[i][j];
        }
    }
    return cb;
}

ColorBlob operator*(const ColorBlob &cBlobOne, const Color &c) {
    ColorBlob cb(cBlobOne.height, cBlobOne.width, Color());
    for(int i = 0; i < cBlobOne.height ; i++) {
        for(int j = 0; j < cBlobOne.width; j++) {
            cb.data[i][j] = cBlobOne.data[i][j] * c;
        }
    }
    return cb;
}

bool operator!(const ColorBlob &cBlobOne) {
    int total = 0;
    int expected = cBlobOne.height * cBlobOne.width;

    for(int i = 0; i < cBlobOne.height ; i++) {
        for(int j = 0; j < cBlobOne.width; j++) {
            if(!(cBlobOne.data[i][j])) {
                total++;
            }
        }
    }

    return (total == expected);
}

std::ostream &operator<<(std::ostream & o_str, const ColorBlob & cb) {
    for(int i = 0; i < cb.height ; i++) {
        for(int j = 0; j < cb.width; j++) {
            o_str << "[" << i << "]" << "[" << j << "]:" << cb.data[i][j] << "\n";
        }
    }

    return o_str;
}

std::istream &operator>>(std::istream &i_str, ColorBlob &cb) {
    for(int i = 0; i < cb.height ; i++) {
        for(int j = 0; j < cb.width; j++) {
            std::cout << "[" << i << "]" << "[" << j << "]: ";
            i_str >> cb.data[i][j];
        }
    }

    return i_str;
}