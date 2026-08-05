class Solution {
     int searchRSA(int[] nums, int target){
        int pivot =pivotIndex(nums);
        if(pivot==-1){
            //perform usual binary search
             return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        //case 3
        if(target >= nums[0]){
              return binarySearch(nums, target, 0, pivot-1);
        }
               return binarySearch(nums, target, pivot+1, nums.length - 1);
    }
    int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
    int pivotIndex(int[] nums) {
          if (nums.length <= 1) {
        return -1;
    }
       int start =0;
       int end=nums.length-1; 
       while(start<=end){
        int mid=start+(end-start)/2;
        //case 1
        if(mid<end && nums[mid]>nums[mid+1]){
            return mid;
        } 
        //case 2
        if(mid>start&& nums[mid]<nums[mid-1]){
            return mid-1;
        }
        //case3
        if(nums[mid]==nums[start]&&nums[mid]==nums[end]){
           if(start<nums.length-1 && nums[start]>nums[start+1]){
            return start;
           }

           start++;
        //case 4
        if(end > 0&& nums[end]<nums[end-1]){
            return end-1;
        }
           end--;
        }
        else if (nums[start] < nums[mid] ||
        (nums[start] == nums[mid] && nums[mid] > nums[end])) {
            start=mid+1;
            }
        else{
            end=mid-1;
        }

        }
       return -1;
    
}
    public boolean search(int[] nums, int target) {
         return searchRSA(nums, target) != -1;
    }
}