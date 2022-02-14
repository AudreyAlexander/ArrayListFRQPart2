import java.util.ArrayList;

public class WordScramble {
    /**
     * Scrambles a given word.
     *
     * @param word the word to be scrambled
     * @return the scrambled word (possibly equal to word)
     * <p>
     * Precondition: word is either an empty string or contains only uppercase letters.
     * Postcondition: the string returned was created from word as follows:
     * - the word was scrambled, beginning at the first letter and continuing from left to right
     * - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     * - letters were swapped at most once
     */
    public static String scrambleWord(String word) {
        String newWord = "";
        int j = 0;
        while (j < word.length()- 1) {
            if (word.substring(j, j+1).equals("A") && !word.substring(j+1, j+2).equals("A")) {
                newWord += word.substring(j+1, j+2);
                newWord += "A";
                j+=2;
            } else {
                newWord += word.substring(j, j+1);
                j+=1;
            }
        }
        if (j < word.length()){
            newWord += word.substring(j);
        }

        return newWord;
    }

    /**
     * Modifies wordList by replacing each word with its scrambled
     * version, removing any words that are unchanged as a result of scrambling.
     *
     * @param wordList the list of words
     *                 <p>
     *                 Precondition: wordList contains only non-null objects
     *                 Postcondition:
     *                 - all words unchanged by scrambling have been removed from wordList
     *                 - each of the remaining words has been replaced by its scrambled version
     *                 - the relative ordering of the entries in wordList is the same as it was
     *                 before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList) {
        int k = 0;
        while (k < wordList.size()) {

            if (scrambleWord(wordList.get(k)).equals(wordList.get(k))) {
                wordList.remove(k);
            } else {
                wordList.set(k, scrambleWord(wordList.get(k)));
                k++;
            }
        }
    }

}