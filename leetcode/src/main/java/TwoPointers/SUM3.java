package TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SUM3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            if(i>=1 && nums[i-1] == nums[i] ){
                continue;
            }
            while(start < end){
                int a = nums[start];
                int b = nums[end];

                int sum = a+b+nums[i];

                if(sum>0){
                    end--;
                }
                else if(sum <0){
                    start++;
                }
                else{
                    list.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                }
            }

        }

        return list;
    }
}
