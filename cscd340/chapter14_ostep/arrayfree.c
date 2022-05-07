#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int *data = (int*)malloc(3 * sizeof(int));
    data[0] = 1;
    data[1] = 2;
    data[2] = 3;

    free(data);
    printf("%d, %d, %d\n", data[0],data[1],data[2]);

    return 0;
}
