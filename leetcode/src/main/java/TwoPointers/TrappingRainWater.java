package TwoPointers;

public class TrappingRainWater {
    //solution 1-beats 58.66%
    public int trap(int[] height) {
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        int ans=0;
        int left=0;
        for(int i=0;i<height.length;i++){
            left=Math.max(height[i],left);
            leftH[i]=left;
        }

        int right=0;
        for(int i=height.length-1;i>=0;i--){
            right=Math.max(height[i],right);
            rightH[i]=right;
        }

        for(int i=0;i<height.length;i++){
            ans+=(Math.min(rightH[i],leftH[i])-height[i]);
        }
        return ans;
    }

    //solution 2-



}
