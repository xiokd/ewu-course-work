/*
Name: Keng Xiong
Compiler: g++14
*/

#include <iostream>
#include <string>

int main() {
    int total_students = 0, counter = 1;
    double score = 0.0, average = 0.0, minimum = 0.0, maximum = 0.0, score_total = 0.0;

    std::cout << "Please enter the number of students: ";
    while(!(std::cin >> total_students) || total_students <= 0 ||(std::cin.get() != '\n')) {
        std::cerr << "Please enter a valid number of students: ";
        std::cin.clear();
        std::cin.ignore(10000, '\n');
    }

    while(counter <= total_students) {
        std::cout << "Enter a score for student " << counter << ": ";
        while(!(std::cin >> score) || (score < 0.0 || score > 100.0) ||(std::cin.get() != '\n')) {
            std::cerr << "Enter a valid score for student " << counter << ": ";
            std::cin.clear();
            std::cin.ignore(10000, '\n');
        }

        if(minimum == 0.0 || score < minimum) {
            minimum = score;
        }

        if(score > maximum) {
            maximum = score;
        }

        score_total += score;
        counter++;
    }

    std::cout << "The average score was " << score_total/total_students << std::endl;
    std::cout << "The minimum score was " << minimum << std::endl;
    std::cout << "The maximum score was " << maximum << std::endl;
    
    return 0;
}

