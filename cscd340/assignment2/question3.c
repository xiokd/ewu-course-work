#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void signal_handler(__attribute__((unused))int signum) { // Signal handler function
    printf("\n");
}

int main(__attribute__((unused))int argc, __attribute__((unused))char *argv[])
{
    int rc = fork();
    
    if (rc < 0) {
        // fork failed; exit
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        // child (new process)
        printf("hello\n");
    } else {
        // parent goes down this path (original process)
        signal(SIGCHLD, signal_handler); // Registers signal handler for child process
        pause(); // Pauses parent process
        printf("goodbye\n");
    }
    return 0;
}