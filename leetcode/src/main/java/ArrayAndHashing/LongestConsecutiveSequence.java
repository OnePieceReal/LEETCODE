package ArrayAndHashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int seqLength=1;
        for(int a : set ){
            //get all the start of the consecutive elements
            if(!set.contains(a-1)){
                int length=1;
                int val=a+1;
                while(set.contains(val)){
                    length++;
                    val++;
                }
                seqLength= Math.max(length, seqLength);
            }
        }
        return seqLength;

    }
}
