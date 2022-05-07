/*
Name: Keng Xiong
Compiler: g++
*/

/* Test file for Assignment 3 */

#include <iostream>
#include "ColorBlob.h"

using namespace std;

int main() {
	ColorBlob cBlob(2, 2, Color());     // creates with the default color, width, and height 
	cout << "cBlob = " << endl;
	cout << cBlob << endl;      //prints the ColorBlob
	ColorBlob cBlobOne(cBlob);
	ColorBlob cBlobTwo(2, 2, Color());
	cout << "Now, you can change color entries: " << endl;
	cin >> cBlobTwo;                                                         // can modify color entries now!
	ColorBlob cBlobThree = cBlobOne + cBlobTwo;       //adds two ColorBlobs
	cout << "cBlobThree = " << endl;
	cout << cBlobThree << endl;
	ColorBlob cBlobFour = cBlobOne - cBlobTwo;  // subtracts one ColorBlob from the other
	cout << "cBlobFour = " << endl;
	cout << cBlobFour << endl;
	Color cColor(0.5, 0.4, 0.45);
	ColorBlob cBlobFive = cBlobOne * cColor;           //multiples the ColorBlob with cColor
	cout << "cBlobFive= " << endl;
	cout << cBlobFive << endl;
	
	if (!cBlobFive)
		cout << "It is not black!" << endl; //if red, green, and blue components of color are zero, then returns true
	else
		cout << "It is black." << endl;
	
	ColorBlob cBlobSix;               //Creates a ColorBlob with the default constructor

	cBlobSix = std::move(cBlobFive);                              //moves cBlobFive to cBlobSix
	cout << "cBlobSix= " << endl;
	cout << cBlobSix << endl;
	ColorBlob cBlobSeven = std::move(cBlobOne);         //moves cBlobOne to cBlobSeven
	cout << "cBlobSeven= " << endl;
	cout << cBlobSeven << endl;

	return 0;
}
