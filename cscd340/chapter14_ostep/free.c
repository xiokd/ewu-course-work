#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int *data = (int*)malloc(3 * sizeof(int));
    data[0] = 1;
    data[1] = 2;
    data[2] = 3;

    free(&data[1]);

    return 0;
}