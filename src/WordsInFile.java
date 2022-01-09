import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Determine which words occur in the greatest number of files, and for each word, which files they occur in
 * use a map of words to the names of files they are in (map a String to an ArrayList of Strings
 * Determine which ArrayList value is the largest (has the most filenames) and its key
 */
public class WordsInFile {
    private HashMap<String, ArrayList<String>> wordMap;

    public WordsInFile() {
        this.wordMap = new HashMap<>();
    }

    /**
     * Clears the map and use a DirectoryResource to select a group of files
     * For each file, put all the words into the map by calling the method addWordsFromFile
     */
    private void buildWordFileMap() {
        this.wordMap.clear();

        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }

    }

    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);

        for (String word : fr.words()) {
            ArrayList<String> filesContainingWord;

            if (!this.wordMap.containsKey(word)) {
                filesContainingWord = new ArrayList<>();
            } else {
                filesContainingWord = this.wordMap.get(word);
            }

            filesContainingWord.add(f.getName());
            this.wordMap.put(word, filesContainingWord);
        }
    }

    /**
     * Get the max number of files any word appears in, considering all words from a group of files
     *
     * @return the max number from the wordMap
     */
    private int maxNumber() {
        int maxNumber = 0;

        for (String word : wordMap.keySet()) {
            int arraySize = wordMap.get(word).size();

            if (arraySize > maxNumber) {
                maxNumber = arraySize;
            }
        }

        return maxNumber;
    }

    /**
     * Prints the name of hte files this words appears in
     *
     * @param word the word to search for
     */
    private void printFilesIn(String word) {
        ArrayList<String> fileNames = wordMap.get(word);

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    /**
     * Call buildWordFileMap to select a group of files and build a HashMap of words
     * Determine the max number of files any word is in, print the files
     */
    public void tester() {
        this.buildWordFileMap();
        int maxNumber = this.maxNumber();

        for (String word : wordMap.keySet()) {
            ArrayList<String> fileNames = wordMap.get(word);
            int fileCount = fileNames.size();

            if (fileCount == maxNumber) {
                System.out.println("Word: " + word);

                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }

                System.out.print("\n");
            }
        }
    }
}
