package TwoPointers;

public class ContainerWithMostWater {

    //attempt 1 - does not work :(
    public int maxArea1(int[] height) {
        int IPV=0; //index+height
        int end=0;
        for(int i=1;i<height.length ;i++){
            if( i+height[i]>IPV){
                IPV=i+height[i];
                end=i;
            }
        }
        int start=0;
        int maxarea =0;
        while(start<end){
            int w=end-start;
            int l = height[start];
            if(l>height[end]){
                l=height[end];
            }
            int area = l*w;
            maxarea = Math.max(maxarea,area);
            start++;
        }
        // System.out.println(end);
        return maxarea;
    }

    public int maxArea(int[] height) {
        int start=0;
        int end = height.length-1;
        int maxarea =0 ;
        while(start<end){
            int w=end-start;
            int l = Math.min(height[start],height[end]);
            maxarea= Math.max(w*l,maxarea);
            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }

        }
        return maxarea;
    }

}
