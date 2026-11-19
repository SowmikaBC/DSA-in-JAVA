class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        long sum=0,max=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(right-left+1>k){
                int x=nums[left];
                map.put(x,map.get(x)-1);
                if(map.get(x)==0)
                    map.remove(x);
                    sum-=nums[left];
                    left++;

            }
            if(right-left+1==k && map.size()==k){
                max=Math.max(max,sum);
            }
        }
        return max;

        
    }
}