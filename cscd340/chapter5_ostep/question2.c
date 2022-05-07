#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>

int main(__attribute__((unused))int argc, __attribute__((unused))char *argv[])
{   
    int output_file = open("./question2_output.txt", O_CREAT|O_WRONLY|O_TRUNC, S_IRWXU);
    printf("hello world (pid:%d)\n", (int) getpid());
    int rc = fork();
    
    if (rc < 0) {
        // fork failed; exit
        fprintf(stderr, "fork failed\n");
        exit(1);
    } else if (rc == 0) {
        // child (new process)
        const char *child_message = "Child process output to file\n";
        printf("hello, I am child (pid:%d) writing to output file\n",
            (int) getpid());
        write(output_file, child_message, strlen(child_message));
        exit(0);

    } else {
        // parent goes down this path (original process)
        const char *parent_message = "Parent process output to file\n";
        printf("hello, I am parent of %d (pid:%d) writing to output file\n",
	       rc, (int) getpid());
        write(output_file, parent_message, strlen(parent_message));
    }

    close(output_file);

    return 0;
}