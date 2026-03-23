package A03_哈希表;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';
            count[index]--;
            if (count[index] < 0) return false;
        }
        return true;
    }
}