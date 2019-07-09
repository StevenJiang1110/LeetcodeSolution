package problem58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        String[] word = s.split(" ");
        if(word.length == 0) return 0;
        return word[word.length - 1].length();
    }
}
