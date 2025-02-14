const morse_code = {
    'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....',
    'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--', 'N': '-.', 'O': '---', 'P': '.--.',
    'Q': '--.-', 'R': '.-.', 'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-',
    'Y': '-.--', 'Z': '--..', '1': '.----', '2': '..---', '3': '...--', '4': '....-', '5': '.....',
    '6': '-....', '7': '--...', '8': '---..', '9': '----.', '0': '-----', ',': '--..--', '.': '.-.-.-',
    '?': '..--..', '/': '-..-.', '-': '-....-', '(': '-.--.', ')': '-.--.-', ' ': '/'
}
const reversedObj = Object.fromEntries(
    Object.entries(morse_code).map(([key, value]) => [value, key])
);
const morseToTxt = (morse:String):String=>{
    let txt ='';
    morse.split(" ")
        .forEach(e => {
            txt += reversedObj[`${e}`] ?? e

        });
    return txt
}
const txtToMorse = (txt:String):String=>{
    let morse ='';
    txt.toUpperCase().split("").forEach(e => {
        morse += morse_code[`${e}`]+" "
    });
    return morse.trim()
}

const morseOrTxt = process.argv.slice(2).join(' ')
morseOrTxt ?
console.log(`MorseCode To Text ${morseToTxt(morseOrTxt)}\nText to MorseCode ${txtToMorse(morseOrTxt)}`):
console.log(`enter some morse or text`);

