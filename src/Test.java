import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        String filename = "input/CommonWordsData/likeit.txt";

        WordFrequencies wf = new WordFrequencies();
        wf.findUnique(filename);
        System.out.println(wf.getWord(wf.findIndexOfMax()) + "\t" + wf.getFreq(wf.findIndexOfMax()));

        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters(filename);
        System.out.println(cip.getCharacterName(cip.findIndexOfMax()) + "\t" + cip.getCharacterCount(cip.findIndexOfMax()));
        cip.characterWithNumParts(10, 15);
    }
}
