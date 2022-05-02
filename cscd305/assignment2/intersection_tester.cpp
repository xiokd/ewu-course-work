/*
Name: Keng Xiong
Compiler: g++
*/

/* Test file for Assignment 2 */

#include <iostream>
#include "Point3D.h"
#include "Ray.h"
#include "Sphere.h"
using namespace std;

int main()
{
    // Variables to receive values from user
    double radius, sphereX, sphereY, sphereZ, rayX, rayY, rayZ, dirX, dirY, dirZ;

    cout << "\nConstructing a sphere." << endl;
    cout << "Enter the radius: " << endl;
    cin >> radius;
    cout << "\nNow the center." << endl;
    cout << "Enter the x coordinate of the sphere's center: " << endl;
    cin >> sphereX;
    cout << "Enter the sphere's y: " << endl;
    cin >> sphereY;
    cout << "Enter the sphere's z: " << endl;
    cin >> sphereZ;

    cout << "\nConstructing a ray." << endl;
    cout << "First the origin." << endl;
    cout << "Enter the x coordinate of the ray's origin: " << endl;
    cin >> rayX;
    cout << "Enter the ray's y: " << endl;
    cin >> rayY;
    cout << "Enter the ray's z: " << endl;
    cin >> rayZ;

    cout << "\nNow the ray's direction." << endl;
    cout << "Enter the x coordinate of the ray's direction: " << endl;
    cin >> dirX;
    cout << "Enter the direction's y: " << endl;
    cin >> dirY;
    cout << "Enter the direction's z: " << endl;
    cin >> dirZ;

    // Creating the class instances
    Point3D sCenter{sphereX, sphereY, sphereZ};
    Sphere s{sCenter, radius};
    Point3D origin{rayX, rayY, rayZ};
    Point3D direction{dirX, dirY, dirZ};
    Ray r{origin, direction};


    r.checkIntersection(s);

    return 0;
}