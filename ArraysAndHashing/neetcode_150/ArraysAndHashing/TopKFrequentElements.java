package neetcode_150.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3,4};
        int k = 2;
        int[] res = topKElements(arr, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] topKElements(int[] arr,int k){
        List<Integer>[] bucket = new List[arr.length + 1];

        Map<Integer,Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for(int pos = bucket.length-1;pos>=0 && count<k;pos--){
            if(bucket[pos] != null){
                for(Integer integer : bucket[pos]){
                    if(count < k)
                    res[count++] = integer;
                    else break;
                }
            }
        }
        return res;
    }
}
