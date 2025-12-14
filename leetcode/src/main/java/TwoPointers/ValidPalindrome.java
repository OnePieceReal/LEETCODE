package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right =s.length()-1;
        while(right>=left){
            char a = s.charAt(left);
            char b = s.charAt(right);
            if(!Character.isLetter(a) && !Character.isDigit(a)){
                left++;
                continue;
            }

            if(!Character.isLetter(b) && !Character.isDigit(b)){
                right--;
                continue;
            }
            if(Character.toLowerCase(a) != Character.toLowerCase(b)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
