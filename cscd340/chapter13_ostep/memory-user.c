#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <signal.h>
#include <stdbool.h>

// Global Variables
double time_spent; 
bool key_interrupt;

void interrupt_handler(__attribute__((unused))int signum) { // Keyboard interrupt handler
    key_interrupt = true;
}

void run(int input_mb) { // Running with no specified time
    int mb_to_byte = (input_mb * 1024 * 1024);
    int *array = (int*)malloc(mb_to_byte);

    clock_t time_start = clock();
    signal(SIGINT, interrupt_handler); // Registers signal handler
    key_interrupt = false;

    for(int i = 0; key_interrupt != true; i++) { // For loop runs until a SIGINT signal is handled and key_interrupt is true
        time_spent = (double) (clock() - time_start) / CLOCKS_PER_SEC;
        array[i]++;
    }

    printf("Time Elapsed: %f\n", time_spent);
    free(array);
}

void run_with_time(int input_mb, int specified_time) { // Running with specified time
    int mb_to_byte = (input_mb * 1024 * 1024);
    int *array = (int*)malloc(mb_to_byte);

    clock_t time_start = clock();

    for(int i = 0; 1; i++) {
        time_spent = (double) (clock() - time_start) / CLOCKS_PER_SEC;
        if(time_spent >= specified_time) {
            break;
        }
        array[i]++;
    }

    printf("Time Elapsed: %f\n", time_spent);
    free(array);
}

int main(int argc, char const *argv[])
{   
    int input_mb, specified_time;

    switch(argc) {
        case 2: // Program has only the number of MB
            input_mb = atoi(argv[1]);
            printf("Current PID: %d\n", getpid());
            printf("Requested Memory: %d MB\n", input_mb);

            run(input_mb);

            break;
        case 3: // Program has the number of MB and specified time
            input_mb = atoi(argv[1]);
            specified_time = atoi(argv[2]);
            printf("Current PID: %d\n", getpid());
            printf("Requested Memory: %d MB\n", input_mb);
            
            run_with_time(input_mb, specified_time);

            break;
        default:
            fprintf(stderr, "Usage:\n memory-user [MEMORY] [TIME]\n");
            exit(EXIT_FAILURE);
    }

    return 0;
}
