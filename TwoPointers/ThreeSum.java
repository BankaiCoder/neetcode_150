package neetcode_150.TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(arr);
        System.out.println("Unique triplets that sum up to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();

        if(arr == null && arr.length<3){
            return new ArrayList<>();

        }

        for(int i=0; i<arr.length-2;i++){
            int l = i+1;
            int r = arr.length-1;

            while(l<r){
                int sum = arr[i]+arr[l]+arr[r];

                if(sum == 0){
                    set.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                }

                if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
