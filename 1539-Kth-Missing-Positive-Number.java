class Solution {
    public int findKthPositive(int[] arr, int k) {
        int Count = 0;
        int arrIndex = 0;
        
        for (int i = 1; ; i++) {
            if (arrIndex < arr.length && arr[arrIndex] == i) {
                arrIndex++;
            } else {
                Count++;
                if (Count == k) {
                    return i;
                }
            }
        }
    }
}
