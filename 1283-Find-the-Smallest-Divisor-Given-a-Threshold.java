class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = highest(nums);
        while(low<= high){
            int mid = (low+ high)/2;
            if(checkThreshold(nums,threshold,mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        //System.out.println(high);
        return low;
    }
    public int highest(int[] arr){
        int highest = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>highest)
                highest = arr[i];
        }
        return highest;
    }
    public boolean checkThreshold(int[] arr, int t, int mid){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
        sum += Math.ceil(((double)arr[i])/(double)mid);
        }
        return sum<=t;
    }
}