/*
Name: Keng Xiong
Compiler: g++
*/

#ifndef INFONODE_H
#define INFONODE_H

template<typename T, typename U, typename V>
        class InfoRepository;

template<typename T, typename U, typename V>
class InfoNode {
    friend class InfoRepository<T, U, V>;
public:
    InfoNode(T& t, U& u, V& v);
private:
    T data_one;
    U data_two;
    V data_three;
    InfoNode* next;
};

template<typename T, typename U, typename V>
InfoNode<T, U, V>::InfoNode(T &t, U &u, V &v) {
    data_one = t;
    data_two = u;
    data_three = v;
}

#endif //INFONODE_H
