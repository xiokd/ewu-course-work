#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(__attribute__((unused))int argc, __attribute__((unused))char *argv[])
{
    printf("hello world (pid:%d)\n", (int) getpid());
    int rc = fork();
    int x = 100;
    
    if (rc < 0) {
        // fork failed; exit
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        // child (new process)
        x = 50; // child process x value
        printf("hello, I am child (pid:%d) with x value of %d\n", (int) getpid(), x);
    } else {
        // parent goes down this path (original process)
        printf("hello, I am parent of %d (pid:%d) with x value of %d\n",
	       rc, (int) getpid(), x);
    }
    return 0;
}