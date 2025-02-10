import sys
MORSE_CODE_DICT = {
    'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....',
    'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--', 'N': '-.', 'O': '---', 'P': '.--.',
    'Q': '--.-', 'R': '.-.', 'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-',
    'Y': '-.--', 'Z': '--..', '1': '.----', '2': '..---', '3': '...--', '4': '....-', '5': '.....',
    '6': '-....', '7': '--...', '8': '---..', '9': '----.', '0': '-----', ', ': '--..--', '.': '.-.-.-',
    '?': '..--..', '/': '-..-.', '-': '-....-', '(': '-.--.', ')': '-.--.-', ' ': '/'
}
def text_to_morse(text):
    text = text.upper()
    morse_code = []

    for char in text:
        if char in MORSE_CODE_DICT:
            morse_code.append(MORSE_CODE_DICT[char])
        else:
            morse_code.append(char)

    return ' '.join(morse_code)

def morse_to_text(morse):
    morse = morse.split(' ')
    reversed_dict = {value: key for key, value in MORSE_CODE_DICT.items()}
    
    text = []

    for code in morse:
        if code in reversed_dict:
            text.append(reversed_dict[code])
        else:
            text.append(code)

    return ''.join(text)

if __name__ == "__main__":
    input_text = " ".join(sys.argv[1:])
    print("Text to Morse Code:", text_to_morse(input_text))
    print("Morse Code to Text:", morse_to_text(input_text))
