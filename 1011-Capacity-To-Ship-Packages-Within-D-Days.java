class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = highest(weights);
        int high= sum(weights);

        while(low<=high){
            int mid = (low + high)/2;
            if(checkIfPossibleToShip(weights, days, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean checkIfPossibleToShip(int[] arr, int days, int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(sum+arr[i] <= mid){
                sum += arr[i];
            }
            else{
                count++;
                sum = arr[i];
            }
        }
        // if(sum <= mid)
        //     count++;
        if(count<=days)
            return true;
        return false;
    }

    public static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int highest(int[] arr){
        int n = arr.length;
        int high = arr[0];
        for(int i = 0 ; i<n;i++){
            high = Math.max(high, arr[i]);
        }
        return high;
    }
}