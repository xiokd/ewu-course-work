#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

#define NUMCPUS (8) // how many threads to start
#define INCREMENTS  (1000000) // how many times each thread will increment counter
#define EXPECTED (NUMCPUS * INCREMENTS)

typedef struct __counter_t {
    int             global;         // global count
    pthread_mutex_t glock;          // global lock
    int             local[NUMCPUS]; // per-CPU count
    int             threshold;
} counter_t;

pthread_t thread[NUMCPUS];

counter_t counter;

void init(counter_t *c, int threshold) {
    c->global = 0;
    c->threshold = threshold;
    pthread_mutex_init(&c->glock, NULL);
    int i;
    for (i = 0; i < NUMCPUS; i++) {
        c->local[i] = 0;
    }
}

void increment(counter_t *c, int threadID) {
    c->local[threadID]++;
    if (c->local[threadID] >= c->threshold) {
        pthread_mutex_lock(&c->glock);
        c->global += c->local[threadID];
        pthread_mutex_unlock(&c->glock);
        c->local[threadID] = 0;
    }
}

int get(counter_t *c) {
    pthread_mutex_lock(&c->glock);
    const int rc = c->global;
    pthread_mutex_unlock(&c->glock);
    return rc;
}

void *thread_start_routine(void * arg){
    const int my_threadID = (int)(long)arg;
    int i;
    for (i = 0; i < INCREMENTS; i++) {
        increment(&counter, my_threadID);
    }
    return NULL;
}

int main(int argc, char *argv[]) {

    const int threshold = atoi(argv[1]);

    struct timeval start_time;
    struct timeval end_time;
    init(&counter, threshold);

    // Initial time
    gettimeofday(&start_time, NULL);

    int i;
    for (i = 0; i < NUMCPUS; i++) {
        pthread_create(&thread[i], NULL, thread_start_routine, (void *)(long)i);
    }

    for (i = 0; i < NUMCPUS; i++) {
        pthread_join(thread[i], NULL);
    }
    
    // Ending time
    gettimeofday(&end_time, NULL);

    double elapsed = ((end_time.tv_sec - start_time.tv_sec) + (end_time.tv_usec - start_time.tv_usec) / 1000000.0);

    printf("CPUs Used: %d\n", NUMCPUS);
    printf("Threshold: %d\n", threshold);
    printf("Time Elapsed: %f\n", elapsed);

    return 0;
}
