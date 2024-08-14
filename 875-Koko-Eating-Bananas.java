class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int[] arr = lowestHighest(piles);
        int low = 1;
        int high = arr[1];
        // System.out.println(low);
        // System.out.println(high);

        while(low<= high){
            int mid = (low + high)/2;
            int ans = timeConsume(mid,piles);
            //System.out.println(ans);
            if(ans<=h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return low;
        
    }
    public int[] lowestHighest(int[] arr){
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<=lowest)
                lowest = arr[i];
            if (arr[i]>highest)
                highest = arr[i];
        }
        int[] ar = {lowest, highest};
        return ar;
    }

    public int timeConsume(int bph, int[] arr){//bph = banana per hours
        // int count = 0;
        // for(int i = 0; i<arr.length; i++){
        //     count += arr[i]/bph;
        //     if(arr[i] % bph != 0){
        //         count++;
        //    }

            //we can also use inbuild method Math.ceil() to implement same logic 
            // for (int pile : piles) {
            // count += Math.ceil(pile / (double)bph); 
        //}
            
        //}


        int totalH = 0;
        int n = arr.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(arr[i]) / (double)(bph));
        }
        return totalH;
        //return count; //counts in which koko will eat whole banana
    }
}