#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void beep(int milliseconds) {
    char cmd[100];

    snprintf(cmd, sizeof(cmd), "play -nq synth %.3f sine 3000", milliseconds / 1000.0);

    system(cmd);
}

void play(const char *s) {
    for (int i = 0; s[i]; i++) {
        if (s[i] == '.')
            beep(100);
        else if (s[i] == '-')
            beep(600);
        usleep(500000);
    }
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        char line[4096];
        while (fgets(line, sizeof(line), stdin)) {
            play(line);
            usleep(1000000);
        }
        return 0;
    }

    for (int i = 1; i < argc; i++) {
        play(argv[i]);
        if (i < argc - 1)
            usleep(1000000);
    }

    return 0;
}
