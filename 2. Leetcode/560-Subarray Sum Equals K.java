**Ques :**
```
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
```

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0, pre_sum = 0;
        //Hash Map created 
        HashMap<Integer,Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < n; i++) {
           // Prefix sum is calculated for all the elements
           pre_sum += nums[i];
            // Edge case i.e. in case subarray starts from 0 index, then 
            // prefix sum is equal to given sum
            if(pre_sum==k)   count++;
            //if difference of prefix sum and k is present as key, that means 
            // subarray with sum k is present
            if(map.containsKey(pre_sum - k))   {
                count += map.get(pre_sum - k);
            }
                
            map.put(pre_sum,map.getOrDefault(pre_sum, 0) + 1);
        }
        return count;
    }
}
```
