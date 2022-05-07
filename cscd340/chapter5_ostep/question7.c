#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(__attribute__((unused))int argc, __attribute__((unused))char *argv[])
{
    printf("hello world (pid:%d)\n", (int) getpid());
    int rc = fork();
    
    if (rc < 0) {
        // fork failed; exit
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        // child (new process)
        close(STDOUT_FILENO);
        printf("This is the child process message\n");
    } else {
        // parent goes down this path (original process)
        wait(NULL); // Waits for child process
        printf("This is the parent process message\n");
    }
    return 0;
}