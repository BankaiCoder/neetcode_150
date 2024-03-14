package neetcode_150.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int height[]){
        int left =0;
        int right=height.length-1;
        int maxArea = 0;

        while(left < right){
            int area = Math.min(height[left], height[right]);
            maxArea  = Math.max(maxArea, area*(right-left));
            while(left<right && height[left] <= area) left++;
            while(left<right && height[right] <= area) right--;

        }
        return maxArea;
    }
}
