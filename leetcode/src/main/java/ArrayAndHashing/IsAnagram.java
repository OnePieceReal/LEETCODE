package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IsAnagram {
    public boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        if(s == null || t==null || s.length() != t.length()) return false;


        for(int i =0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            }else{
                map1.put(s.charAt(i),1);
            }
        }

        for(int i =0;i<t.length();i++){
            if(map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
            }else{
                map2.put(t.charAt(i),1);
            }
        }

        if(map1.size() != map2.size()){
            return false;
        }
        //compare the two hashmaps to deduce if the strings are anagram
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            if(!map2.containsKey(entry.getKey())){
                return false;
            }
            int val = map2.get(entry.getKey());
            if(val != entry.getValue()){
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram2(String s, String t) {
        //consider base conditions
        if(s == null || t == null || s.length() != t.length())return false;
        //better solution - we sort the string and then compare
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}