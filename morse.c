#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_LEN 1000

char* morse_code_dict[] = {
    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
    "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", 
    ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", 
    "--..--", ".-.-.-", "..--..", "-..-.", "-....-", "-.--.", "-.--.-", "/"
};

char chars[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.?/-() ";

void text_to_morse(char* text) {
    for (int i = 0; text[i] != '\0'; i++) {
        char ch = toupper(text[i]);
        
        if (ch >= 'A' && ch <= 'Z') {
            printf("%s ", morse_code_dict[ch - 'A']);
        } else if (ch >= '0' && ch <= '9') {
            printf("%s ", morse_code_dict[ch - '0' + 26]);
        } else {
            for (int j = 36; j < sizeof(chars) - 1; j++) {
                if (ch == chars[j]) {
                    printf("%s ", morse_code_dict[j]);
                    break;
                }
            }
        }
    }
    printf("\n");
}

void morse_to_text(char* morse) {
    char* token = strtok(morse, " ");
    while (token != NULL) {
        int found = 0;
        
        for (int i = 0; i < sizeof(morse_code_dict) / sizeof(morse_code_dict[0]); i++) {
            if (strcmp(token, morse_code_dict[i]) == 0) {
                printf("%c", chars[i]);
                found = 1;
                break;
            }
        }
        
        if (!found) {
            printf("?");
        }
        
        token = strtok(NULL, " ");
    }
    printf("\n");
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        printf("%s <Enter morse or text>\n", argv[0]);
        return 1;
    }
    
    char input_text[MAX_LEN];
    
    input_text[0] = '\0';
    for (int i = 1; i < argc; i++) {
        strcat(input_text, argv[i]);
        if (i < argc - 1) {
            strcat(input_text, " ");
        }
    }
    
    printf("Text to Morse Code: ");
    text_to_morse(input_text);
    
    printf("Morse Code to Text: ");
    morse_to_text(input_text);

    return 0;
}

