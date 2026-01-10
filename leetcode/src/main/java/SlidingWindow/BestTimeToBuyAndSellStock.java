package SlidingWindow;

public class BestTimeToBuyAndSellStock {


    //attempt 1-2ms beats 42.04%
    public int maxProfit1(int[] prices) {
        //initialization
        int arr1[] = new int[prices.length];
        int arr2[] = new int[prices.length];
        //base condition
        if(prices.length==0) return 0;
        //find the min array from left to right
        //find max array from right to left
        int min = prices[0];
        int max=prices[prices.length-1];
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max=Math.max(max,prices[prices.length-1-i]);
            arr1[i]=min;
            arr2[prices.length-1-i]=max;

        }
        //find result via max(arr2-arr1)
        int result =0;
        for(int i=0;i<prices.length;i++){
            result= Math.max(result,arr2[i]-arr1[i]);
        }
        return result;
    }

    //two pointer solutions (still  2ms lmao)
    public int maxProfit2(int[] prices) {
        int l=0;
        int r=1;
        if(prices.length <=1){
            return 0;
        }
        int result=0;
        while(r<prices.length){
            if(prices[l]>prices[r]){
                l=r;
            }
            else{
                result = Math.max(result,prices[r]-prices[l]);
            }
            r++;
        }
        return result;
    }

}
