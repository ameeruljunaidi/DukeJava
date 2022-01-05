import edu.duke.FileResource;

public class CaesarCipher {

    /**
     * @param input the original string itself
     * @param key   is the amount of shift that needs to be done to the alphabets
     * @return a string that has been encrypted using the caesar cipher algorithm
     */
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);

        String lower = "abcdefghijklmnopqrstuvwxyz";
        String shiftedLower = lower.substring(key) + lower.substring(0, key);
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedUpper = upper.substring(key) + upper.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            if (currChar >= 'a' && currChar <= 'z') {
                int index = lower.indexOf(currChar);

                if (index != -1) {
                    char newChar = shiftedLower.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int index = upper.indexOf(currChar);

                if (index != -1) {
                    char newChar = shiftedUpper.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }

        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("Key is " + key + "\n" + encrypted);
    }

    /**
     * @param input the string to modify
     * @param key1 key to modify odd character
     * @param key2 key to modify even character
     * @return a string that has been encrypted using some algorithm
     */
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);

        String odd = encrypt(encrypted.toString(), key1);
        String even = encrypt(encrypted.toString(), key2);

        for (int i = 0; i < encrypted.length(); i++) {
            if ((i + 1) % 2 == 0) {
                encrypted.setCharAt(i, even.charAt(i));
            } else {
                encrypted.setCharAt(i, odd.charAt(i));
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
    }
}

