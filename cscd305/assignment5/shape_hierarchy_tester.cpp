#include <iostream>
#include "Rectangle.h"
#include "Box.h"
#include "Circle.h"
#include "Triangle.h"
#include "Sphere.h"
#include "Cylinder.h"

using namespace std;

int main() {

	Rectangle rectangle("Rectangle", 3.1, 1.2);
	Box box("Box", 4.5, 4.5, 6.0);
	Circle circle("Circle", 2.1);
	Triangle triangle("Triangle", 3.0, 4.0);
	Sphere sphere("Sphere", 6.0);
	Cylinder cylinder("Cylinder", 3.0, 4.0);
	Shape *shape[6];

	shape[0] = &rectangle;
	shape[1] = &box;
	shape[2] = &circle;
	shape[3] = &triangle;
	shape[4] = &sphere;
	shape[5] = &cylinder;

	for (int i = 0; i < 6; i++) {
		cout << "Shape " << i << ": ";
		shape[i]->printDetail();
	}

	return 0;
}