class Solution {
   private boolean canEat(int[] piles, int h, int speed) {
    int hours=0;
    for(int pile:piles){
    hours+=(pile+speed-1)/speed;
    }
    return hours<=h;
   }  

    public int minEatingSpeed(int[] piles, int h) {
         int start =1;
    int end =0;//initially we don't know max value
    for(int pile:piles){
        end=Math.max(end,pile);
    }
    while (start<end){
        int mid=start+(end-start)/2;
        if(canEat(piles,h,mid)){
            end=mid;//search left hours we find is less than given h 
        }
        else{
            start=mid+1;//search right hours>8 so we need increase speed
        }
    }
    return start;//Koko can only spend whole hours so it can't be 2.5 or 0.5hrs so we use ceil concept here
    }
}