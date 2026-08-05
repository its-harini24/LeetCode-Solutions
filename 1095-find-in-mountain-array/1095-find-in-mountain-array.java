
class Solution {
    int Search(MountainArray mountainArr,int target){
            int peak = findPeakElement( mountainArr);
            int first = orderAgnosticBS( mountainArr,target,0,peak);
            if(first!=-1){
                return first;
            }
             return orderAgnosticBS( mountainArr,target,peak+1, mountainArr.length()-1);
        }
        int findPeakElement(MountainArray mountainArr) {
        int start=0;
        int end = mountainArr.length()-1;
        while(start<end){
            int mid= start+(end-start)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end =mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;  
    }
     int orderAgnosticBS(MountainArray mountainArr,int target,int start,int end){
        boolean isAsc =mountainArr.get(start) < mountainArr.get(end);
         
         while(start<=end){
            int mid= start+(end-start)/2; 
            if(mountainArr.get(mid)==target){
                return mid;
            }
            if(isAsc){
                if(target>mountainArr.get(mid)){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(target<mountainArr.get(mid)){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            
         }

         }         
     return -1;
     }
    public int findInMountainArray(int target, MountainArray mountainArr) {
     return Search(mountainArr, target);   
    }
}