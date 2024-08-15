class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] arr = lowhigh(bloomDay);
        int low = arr[0];
        int high = arr[1];
        if((double)m*k > (double)bloomDay.length)
            return -1;
        while(low<=high){
            int mid = (low + high)/2;
            //int boquetCount= countBouquets(bloomDay,mid,k);
            if(countBouquets(bloomDay, mid,k,m)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return low;
    }
    public int[] lowhigh(int[] arr){
        int minimum = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>highest){
                highest = arr[i];
            }
            if(arr[i]<= minimum){
                minimum = arr[i];
            }
        }
        int[] ar = {minimum, highest};
        return ar;
    }

    public boolean countBouquets(int[] arr, int mid, int k, int m){
        int count = 0;
        int result = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<=mid){
                count++;
            }
            else{
                result += count/k;
                count = 0;
            }
        }
        result += count/k;
        return result>= m;
    }
}