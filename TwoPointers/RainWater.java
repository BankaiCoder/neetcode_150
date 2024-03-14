package neetcode_150.TwoPointers;

public class RainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rainWaterTrapping(arr));
    }

    public static int rainWaterTrapping(int[] height){
        int n = height.length;

        int totalWater = 0;
        int max =0;
        int maxIndex =0;

        for(int i=0;i<n;i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = 0;
        for(int i=0;i<maxIndex;i++){
            leftMax = Math.max(height[i],leftMax);
            int water = Math.min(max,leftMax)-height[i];
            totalWater+=water;
        }

        leftMax = 0;
        for(int i=n-1;i>maxIndex;i--){
            leftMax = Math.max(height[i],leftMax);
            int water = Math.min(leftMax, max)-height[i];
            totalWater+=water;
        }
        return totalWater;
    }
}
