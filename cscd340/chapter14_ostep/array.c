#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int *data = (int*)malloc(100 * sizeof(int));
    data[100] = 0;
    free(data);
    return 0;
}
