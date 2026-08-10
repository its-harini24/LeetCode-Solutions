class Solution {
    int calaculateSum (int[] nums, int divisor){
        int sum=0;
        for(int num:nums){
            sum=sum+(num+divisor-1)/divisor;//find the sum that return ceil 
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
      //minimum divisor can be 1 and maximum be max of nums which is the start and end in trhis problem
      int max = nums[0];
      for (int num:nums){
        max=Math.max(max,num);
      }
      int start =1;
      int end =max;
     while(start<=end){
        int mid = start+(end-start)/2;//mid is an divisor 
        int sum = calaculateSum(nums,mid);
        // main clue:
        // divisor increases| sum decreases
        if(sum>threshold){
            start=mid+1;//eliminate smaller divisors; search right
        }
        else {
            end=mid-1;// search left 
        }
      }
      return start;//  the smallest divisor that satisfies sum <= threshold.
      }
      
     

        
    }
