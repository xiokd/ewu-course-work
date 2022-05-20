#include <iostream>
#include "Graph.h"

using namespace std;

int main(int argc, char** argv){
	Graph g;

	bool cityInformation = g.loadCityInformation("Terrain.obj");
	
	if (!cityInformation) {
		cerr << "No information available";
		return 0;
	}
	
	g.Generate();                   //Generates the map containing the connectivity information for 46 cities


	g.Print(); //shows the connectivity information for all 46 cities;

	g.showConnectivity(0); //shows connectivity information for city 0;
	g.showConnectivity(13); //shows connectivity information for city 13
	return 0;
}


