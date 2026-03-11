package SlidingWindow;

import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        HashSet<Character> set = new HashSet<>(); //no duplicate characters allowed in a hashset
        int maxlen=0;
        while(start <s.length() && end<s.length()){
            char c = s.charAt(end);
            if(!set.contains(c)){
                set.add(c);
                end++;
            }
            else{
                maxlen=Math.max(maxlen,set.size());
                set.remove(s.charAt(start));
                start++;
            }
        }
        maxlen=Math.max(maxlen,set.size());
        return maxlen;
    }
}
