package neetcode_150.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class countDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,6};
        System.out.println(isDuplicacy(arr));
    }

    public static boolean isDuplicacy(int[] arr){
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;

    }
}
