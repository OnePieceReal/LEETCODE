package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagram {
    public boolean isAnagram(String s, String t) {
        //consider base conditions
        if(s == null || t == null || s.length() != t.length())return false;
        //better solution - we sort the string and then compare
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> biglist = new LinkedList<>();
        for(int i =0;i< strs.length ;i++){
            List<String> list = new LinkedList<>();
            if(strs[i] == null) continue; //skip null values
            list.add(strs[i]);
            for(int j =0;j<strs.length;j++){
                if(j != i && isAnagram(strs[i],strs[j])){
                    list.add(strs[j]);
                    strs[j]=null;
                }
            }
            strs[i] = null;
            biglist.add(list);
        }
        return biglist;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        String[] arr = new String[strs.length];
        List<List<String>> e = new LinkedList<>();
        for(int i=0;i<strs.length;i++){
            if(strs[i]==null) continue;
            char[] arr2 = strs[i].toCharArray();
            Arrays.sort(arr2);
            arr[i]= new String(arr2);
        }

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                LinkedList<String> c = map.get(arr[i]);
                c.add(strs[i]);
            }
            else{
                LinkedList<String> d = new LinkedList<>();
                d.add(strs[i]);
                map.put(arr[i],d);
            }

        }


        for(LinkedList f:map.values()){
            e.add(f);
        }

        return e;
    }
}
