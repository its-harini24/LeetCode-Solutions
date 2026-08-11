class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int start = bloomDay[0];
        int end = bloomDay[0];
        for(int day:bloomDay){
            start = Math.min(start,day);
            end=Math.max(end,day);
        }   
        while(start< end){
            int mid = start+ (end-start)/2;
            int consecutive = 0;
            int bouquet = 0;
            for (int day:bloomDay){
            
            if (day <= mid) {
    consecutive++;

    if (consecutive == k) {
        bouquet++;
        consecutive = 0;
    }
    } else {
    consecutive = 0;
    }}
            if(bouquet>=m){
                end=mid;
            }
            else{
                start=mid+1;
            }

        }
        return start;
         }
}