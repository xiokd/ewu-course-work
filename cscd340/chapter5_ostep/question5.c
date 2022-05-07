#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(__attribute__((unused))int argc, __attribute__((unused))char *argv[])
{
    int rc = fork();
    printf("Printing rc value: %d\n", rc);

    if (rc < 0) {
        // fork failed; exit
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        // child (new process)
        int child_return_value = wait(NULL); // If child called wait()
        printf("hello, I am child (pid:%d)\n", (int) getpid());
        printf("Child wait() return value: %d\n", child_return_value);
    } else {
        // parent goes down this path (original process)
        //int parent_return_value = wait(NULL); // Using wait() in the parent process
        printf("hello, I am parent of %d (pid:%d)\n",
	       rc, (int) getpid());
        //printf("Parent return value: %d\n", parent_return_value);
    }
    return 0;
}