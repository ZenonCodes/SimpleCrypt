import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    static HashMap<Character, Character> cipher = new HashMap<>();

    ROT13(Character cs, Character cf) {
        do {
            cipher.put((char) ((cs++ % 26) + 97), (char) ((cf++ % 26) + 97));
        } while (cipher.size() < 26);
        do {
            cipher.put(Character.toUpperCase(((char) ((cs++ % 26) + 97))), Character.toUpperCase((char) ((cf++ % 26) + 97)));
        } while (cipher.size() < 52);

    }

    public static HashMap<Character, Character> custRot(String s, char cf) {
        final HashMap<Character, Character> custCipher = new HashMap<>();
        char[] cArray = s.toCharArray();
        do {
            custCipher.put((char) ((cArray[0]++ % s.length()) + 97), (char) ((cf++ % s.length()) + 97));
        } while (custCipher.size() < s.length());

        do {
            custCipher.put(Character.toUpperCase(((char) ((cArray[0]++ % s.length()) + 97))), Character.toUpperCase((char) ((cf++ % s.length()) + 97)));
        } while (custCipher.size() < s.length() * 2);

        return custCipher;

    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        char[] charArray = text.toCharArray();
        char[] returnString = new char[text.length()];
        for (int i = 0; i < charArray.length; i++) {
            if (!cipher.containsValue(charArray[i])) {
                returnString[i] = (charArray[i]);
                continue;
            }
            returnString[i] = cipher.get(charArray[i]);
        }
        return new String(returnString);
    }

    public String encrypt(String text) {
        char[] charArray = text.toCharArray();
        char[] returnString = new char[text.length()];
        for (int i = 0; i < charArray.length; i++) {
            if (!cipher.containsValue(charArray[i])) {
                returnString[i] = (charArray[i]);
                continue;
            }
            returnString[i] = cipher.get(charArray[i]);
        }
        return new String(returnString);
    }

    public String decrypt(String text) {
        char[] charArray = text.toCharArray();
        char[] returnString = new char[text.length()];
        for (int i = 0; i < charArray.length; i++) {
            if (!cipher.containsValue(charArray[i])) {
                returnString[i] = (charArray[i]);
                continue;
            }
            returnString[i] = cipher.get(charArray[i]);
        }
        return new String(returnString);
    }

    public static String rotate(String s, Character c) {
        char[] charArray = s.toCharArray();
        char chara = charArray[0];
        HashMap<Character, Character> custCipher =  custRot(s,c);

        char[] returnString = new char[s.length()];
        for (int i = 0; i < charArray.length; i++) {
            if (!custCipher.containsKey(charArray[i])) {
                returnString[i] = (charArray[i]);
                continue;
            }
            returnString[i] = custCipher.get(charArray[i]);
        }

       return String.valueOf(returnString);
    }

}
