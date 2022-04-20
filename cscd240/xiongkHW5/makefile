#makefile for fileTest

file:file.o fileTest.o
	gcc file.o fileTest.o -o file

file.o:file.c fileTest.h
	gcc -c file.c

fileTest.o:fileTest.c fileTest.h
	gcc -c fileTest.c

clean:
	rm *.o file
