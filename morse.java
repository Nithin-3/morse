import java.util.HashMap;
import java.util.Map;

public class morse{
    private static final Map<String, String> MORSE_CODE = new HashMap<>();
    static {
        MORSE_CODE.put("A", ".-"); MORSE_CODE.put("B", "-..."); MORSE_CODE.put("C", "-.-."); MORSE_CODE.put("D", "-.."); MORSE_CODE.put("E", "."); MORSE_CODE.put("F", "..-."); 
        MORSE_CODE.put("G", "--."); MORSE_CODE.put("H", "...."); MORSE_CODE.put("I", ".."); MORSE_CODE.put("J", ".---"); MORSE_CODE.put("K", "-.-"); MORSE_CODE.put("L", ".-.."); 
        MORSE_CODE.put("M", "--"); MORSE_CODE.put("N", "-."); MORSE_CODE.put("O", "---"); MORSE_CODE.put("P", ".--."); MORSE_CODE.put("Q", "--.-"); MORSE_CODE.put("R", ".-."); 
        MORSE_CODE.put("S", "..."); MORSE_CODE.put("T", "-"); MORSE_CODE.put("U", "..-"); MORSE_CODE.put("V", "...-"); MORSE_CODE.put("W", ".--"); MORSE_CODE.put("X", "-..-");
        MORSE_CODE.put("Y", "-.--"); MORSE_CODE.put("Z", "--.."); MORSE_CODE.put("1", ".----"); MORSE_CODE.put("2", "..---"); MORSE_CODE.put("3", "...--"); MORSE_CODE.put("4", "....-");
        MORSE_CODE.put("5", "....."); MORSE_CODE.put("6", "-...."); MORSE_CODE.put("7", "--..."); MORSE_CODE.put("8", "---.."); MORSE_CODE.put("9", "----."); MORSE_CODE.put("0", "-----"); 
        MORSE_CODE.put(", ", "--..--"); MORSE_CODE.put(".", ".-.-.-"); MORSE_CODE.put("?", "..--.."); MORSE_CODE.put("/", "-..-."); MORSE_CODE.put("-", "-....-");
        MORSE_CODE.put("(", "-.--."); MORSE_CODE.put(")", "-.--.-"); MORSE_CODE.put(" ", "/");
    }
    private static final Map<String, String> REVERSED_MORSE_CODE = new HashMap<>();

    static {
        for (Map.Entry<String, String> entry : MORSE_CODE.entrySet()) {
            REVERSED_MORSE_CODE.put(entry.getValue(), entry.getKey());
        }
    }

    public static String morseToTxt(String morse) {
        StringBuilder txt = new StringBuilder();
        String[] morseArray = morse.split(" ");
        for (String symbol : morseArray) {
            txt.append(REVERSED_MORSE_CODE.getOrDefault(symbol, symbol));
        }
        return txt.toString();
    }

    public static String txtToMorse(String txt) {
        StringBuilder morse = new StringBuilder();
        txt = txt.toUpperCase();
        for (int i = 0; i < txt.length(); i++) {
            String letter = String.valueOf(txt.charAt(i));
            morse.append(MORSE_CODE.getOrDefault(letter, ""))
                .append(" ");
        }
        return morse.toString().trim();
    }

    public static void main(String[] args) {
        String input = String.join(" ", args);
        if(input.length() == 0 ){ System.out.println("entery morse or text");}
        else {
            System.out.println("MorseCode To Text: " + morseToTxt(input));
            System.out.println("Text to MorseCode: " + txtToMorse(input));
        }
    }
}

