package neetcode_150.ArraysAndHashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAngram {

public static void main(String[] args) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> list= groupAnagrams(strs);
   
    System.out.println(list);
}

     @SuppressWarnings("null")
    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null && strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> freqStringMap = new HashMap<>();

        for(String str : strs){
            String freqString = getFrequency(str);

            if(freqStringMap.containsKey(freqString)){
                freqStringMap.get(freqString).add(str);
            }
             else{
                 List<String> strList = new ArrayList<>();
                 strList.add(str);
                 freqStringMap.put(freqString,strList);
                 }
        }
        return new ArrayList<>(freqStringMap.values());
    }

    private static String getFrequency(String str){
        int[] freq = new int[26];

        for(char c : str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder freqString = new StringBuilder("");

        char c = 'a';
        for(int i : freq){
            freqString.append(c);
            freqString.append(i);
            c++;
        }

        return freqString.toString();
    }
}
