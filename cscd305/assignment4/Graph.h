/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef GRAPH_H
#define GRAPH_H

#include <cmath>
#include <fstream>
#include <map>
#include <set>
#include <sstream>
#include <vector>

#include "Point3D.h"

class Graph {
private:
    std::vector<Point3D> city_coordinates;
    std::vector<int> city_indices;
    std::map<int, std::set<int>> connectivity;
public:
    /* Extracts information from filename to initialize mVertices and vIndices */
    bool loadCityInformation(const char *filename);

    /* Generates the connectivity map among cities
     * Calls Link function to generate connectivity information for all cities */
    void Generate();

    /* Prints connectivity information of different cities */
    void Print();

    /* Displays connectivity information for a particular city "a" and finds
     * distance information of neighboring cities */
    void showConnectivity(int a);
};


#endif //GRAPH_H
