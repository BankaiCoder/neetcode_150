package neetcode_150.ArraysAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] res = getProduct(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getProduct(int[] nums){
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        left[0] = 1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i=nums.length-2;i>-1;i--){
            right[i] = right[i+1]*nums[i+1];
        }

        int res[] = new int[nums.length];
        for(int i=0;i<res.length;i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }
}
