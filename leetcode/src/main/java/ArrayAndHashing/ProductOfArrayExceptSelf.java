package ArrayAndHashing;

public class ProductOfArrayExceptSelf {
    //solution does not work-attempt 1 cuz o(n^2)
    public int[] productExceptSelf1(int[] nums) {
        int arr_length = nums.length*(nums.length-1);
        if (arr_length<0) return new int[nums.length];
        int[] arr = new int[arr_length];
        int a=0;
        int b=0;
        //idea: make an array with the values we need to multiply for (nums.length -1)*nums.length
        for(int i=0;i<arr_length;i++){
            if(a==b)
            {
                i--;
                b++;
            }
            else{
                arr[i]=nums[b];
                b++;
            }
            if(b>=nums.length){
                b=0;
                a++;
            }
        }


        int[] arr2 = new int[nums.length];
        int finalProduct =1;
        int j=1;
        int arrCounter=0;
        for(int i=0;i<arr.length;i++){
            finalProduct = finalProduct*arr[i];
            // System.out.println(arr[i]);

            if(j==nums.length-1){
                // System.out.println("---->"+finalProduct);
                arr2[arrCounter]=finalProduct;
                arrCounter++;
                j=0;
                finalProduct =1;

            }
            j++;

        }
        return arr2;
    }

    //attempt 2-works but runtime=3ms
    public int[] productExceptSelf2(int[] nums) {

        int n = nums.length;

        // Step 1 - prefix
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // Step 2 - postfix
        int[] postfix = new int[n];
        postfix[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        // Step 3 - answer
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * postfix[i];
        }

        return ans;
    }

    //2ms - beats 92% solution
    public int[] productExceptSelf3(int[] nums) {

        int n = nums.length;
        //calculate prefix first
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
            // System.out.println(prefix[i]);
        }

        // int[] postfix = new int[n];
        // postfix[n-1] = 1;
        // for (int i = n-2; i >= 0; i--) {
        //     postfix[i] = postfix[i+1] * nums[i+1];
        //                 System.out.println("---."+postfix[i]);

        // }
        int postfix =1;
        for (int i = n-1; i >= 0; i--) {
            prefix[i]=prefix[i]*postfix;
            postfix *= nums[i];
        }
        return prefix;
    }


}
