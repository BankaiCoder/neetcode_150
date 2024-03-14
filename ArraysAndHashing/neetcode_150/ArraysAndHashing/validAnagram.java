package neetcode_150.ArraysAndHashing;

public class validAnagram {
public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";

    System.out.println(isAnagram(s,t));
}
    public static boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        s = s.replace(" ","");
        t = t.replace(" ","");

        int[] count = new int[26];

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            count[t.charAt(i)-'a']--;
        }

        for(int counts : count){
            if(counts != 0){
                return false;
            }
        }
        return true;
    }
}