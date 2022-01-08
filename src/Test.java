import edu.duke.FileResource;

public class Test {
    public static void main(String[] args) {
        FileResource fr = new FileResource("input/mysteryTwoKeysQuiz.txt");
        String message = fr.asString();

        TestCaesarCipherTwo tcct = new TestCaesarCipherTwo();
        System.out.println(tcct.breakCaesarCipher(message));
    }
}
