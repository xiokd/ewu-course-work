#include <stdio.h>

#define MAXROWS 10
#define MAXCOLS 10

void readArrayElements(int a[][MAXCOLS], int nRows, int nCols);
void writeArrayElements(int a[][MAXCOLS], int nRows, int nCols);
void addArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols);
void subtractArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols);
void multiplyArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols);

int main(){

	int rows, cols;
        char option;

       	/* Array definition*/
        int a[MAXROWS][MAXCOLS], b[MAXROWS][MAXCOLS], c[MAXROWS][MAXCOLS];

	printf("Enter the number of rows:");
	scanf("%d", &rows);
	printf("Enter the number of columns:");
	scanf("%d", &cols);
	printf("\nFirst Array: \n");
	readArrayElements(a, rows, cols);
	printf("\nSecond Array: \n");
	readArrayElements(b, rows, cols);


        printf("Enter your option: 'A', 'B' or 'M':");
        scanf(" %c", &option);
       	switch (option) {
	case 'A':
	case 'a':
		printf("Adding array 'a' and 'b'\n");
		addArrayElements(a, b, c, rows, cols);
		printf("After adding array 'a' and 'b', the resultant array is: \n");
		writeArrayElements(c, rows, cols);
		break;
	case 'B':
	case 'b':
		printf("Subtracting array 'b' from array 'a'\n");
		subtractArrayElements(a, b, c, rows, cols);
                printf("After subtracting array 'b' from array 'a', the resultant array is:\n");
                writeArrayElements(c, rows, cols);
		break;
	case 'M':
	case 'm':
		printf("Multiplying array 'a' with array 'b'\n");
		multiplyArrayElements(a, b, c, rows, cols);
                printf("After multiplying array 'a' with array 'b', the resultant array is:\n");
                writeArrayElements(c, rows, cols);
		break;
	default:
		printf("Invalid input\n");
	}
        return 0;
}

void readArrayElements(int a[][MAXCOLS], int nRows, int nCols){

        int i, j;
        for ( i = 0; i < nRows; i++){
                printf("Enter data for row no: %d\n", i);

                for ( j = 0; j < nCols; j++){
                        scanf("%d", &a[i][j]);
                }
        }
        return;
}

//Print the array 'a'
void writeArrayElements(int a[][MAXCOLS], int nRows, int nCols){
      // insert your code here!( 4pts)

			int i, j;
			for ( i = 0; i < nRows; i++){
							for ( j = 0; j < nCols; j++){
											printf("%5d", a[i][j]);
							}
							printf("\n");
			}
			return;
}

// Add array 'a' with array 'b'
void addArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols){
      // insert your code here! ( 2 pts)

			int i, j;
			for ( i = 0; i < nRows; i++){
							for ( j = 0; j < nCols; j++){
											c[i][j] = a[i][j] + b[i][j];
							}
			}
			return;
}

// Subtract array 'b' from array 'a'

void subtractArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols){
      // insert your code here! ( 2 pts)

			int i, j;
			for ( i = 0; i < nRows; i++){
							for ( j = 0; j < nCols; j++){
											c[i][j] = b[i][j] - a[i][j];
							}
			}
			return;
}


// Multiply array 'a' with array 'b'

void multiplyArrayElements(int a[][MAXCOLS], int b[][MAXCOLS], int c[][MAXCOLS], int nRows, int nCols){
      // insert your code here! ( 2 pts)

			int i, j;
			for ( i = 0; i < nRows; i++){
							for ( j = 0; j < nCols; j++){
										c[i][j] = a[i][j] * b[i][j];
							}
			}
			return;
}
