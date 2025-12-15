package TwoPointers;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end = numbers.length-1;
        while(start<end){
            int val = target - numbers[start];
            if(val < numbers[end]){
                end--;
            }
            else if (val > numbers[end]){
                start++;
            }
            else{
                return new int[]{start+1,end+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution exists");
    }
}
