package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    class Node {
        int id;
        int value;

        Node(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(k==0) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value)
                return Integer.compare(b.value, a.value);
            return Integer.compare(b.value, a.value);
        });



        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }

        int[] arr = new int[k];
        for(int i =0;!pq.isEmpty() && i <k;i++){
            arr[i]=pq.poll().id;
        }
        return arr;
    }
}
