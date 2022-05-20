/*
Name: Keng Xiong
Compiler: g++
*/

#include "Graph.h"

bool Graph::loadCityInformation(const char *filename) {
    std::ifstream file(filename);
    int connection_one, connection_two, connection_three;
    double point_x, point_y, point_z;
    std::string line_type, input_line;

    while(std::getline(file, input_line)) {
        if(input_line == "\r" || input_line.empty()) { // Checks for empty lines
            continue;
        } else {
            std::istringstream i_stream(input_line);
            i_stream >> line_type;

            if(line_type == "p") {
                i_stream >> point_x >> point_y >> point_z;
                city_coordinates.emplace_back(point_x, point_y, point_z);
            } else if (line_type == "c") {
                i_stream >> connection_one >> connection_two >> connection_three;
                city_indices.push_back(connection_one);
                city_indices.push_back(connection_two);
                city_indices.push_back(connection_three);
            } else {
                return false;
            }
        }
    }

    return true;
}

void Graph::Generate() {
    int connection_one, connection_two, connection_three;
    std::set<int> connection_array[city_coordinates.size()];

    for(int i = 0; i < city_coordinates.size(); i++) { // Iterates through all keys
        // Element index values for each set of city indices
        connection_one = 0;
        connection_two = 1;
        connection_three = 2;

        while(connection_one < city_indices.size()) { // Searches city indice sets for the key value and links them
            if(city_indices[connection_one] == i) {
                connection_array[i].insert(city_indices[connection_two]);
                connection_array[i].insert(city_indices[connection_three]);
            } else if (city_indices[connection_two] == i) {
                connection_array[i].insert(city_indices[connection_one]);
                connection_array[i].insert(city_indices[connection_three]);
            } else if (city_indices[connection_three] == i){
                connection_array[i].insert(city_indices[connection_one]);
                connection_array[i].insert(city_indices[connection_two]);
            }

            // Increments all indexes to the next set of city indices
            connection_one += 3;
            connection_two += 3;
            connection_three += 3;
        }
    }

    for(int i = 0; i < city_coordinates.size(); i++)  {
        connectivity.insert(make_pair(i, connection_array[i]));
    }

}

void Graph::Print() {
    for(auto it_key = connectivity.begin(); it_key != connectivity.end(); ++it_key) {
        std::cout << " [" << (*it_key).first << " ] ";
        for(auto it_element = (*it_key).second.begin(); it_element != (*it_key).second.end(); it_element++) {
            std::cout << (*it_element) << " ";
        }
        std::cout << std::endl;
    }
}

void Graph::showConnectivity(int a) {
    std::cout << "Showing connectivity for Node " << a << " :" << std::endl;

    double a_x = city_coordinates[a].getX();
    double a_y = city_coordinates[a].getY();
    double a_z = city_coordinates[a].getZ();

    double connected_x, connected_y, connected_z, distance;
    std::vector<double> results;

    for(auto it_key = connectivity.find(a)->second.begin(); it_key != connectivity.find(a)->second.end(); it_key++) {
        connected_x = city_coordinates[*it_key].getX();
        connected_y = city_coordinates[*it_key].getY();
        connected_z = city_coordinates[*it_key].getZ();

        distance = sqrt(pow((a_x - connected_x), 2) + pow((a_y - connected_y), 2) + pow((a_z - connected_z), 2));

        std::cout << "[" << a << "-" << *it_key << " ] " << distance << std::endl;
    }
}