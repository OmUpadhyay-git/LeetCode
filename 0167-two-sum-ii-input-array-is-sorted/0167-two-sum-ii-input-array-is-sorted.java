class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int arr[] = new int[2];

        while(start<end){
            int sum = numbers[start]+numbers[end];
            if (sum == target){
                arr[0]=start+1;
                arr[1]=end+1;
                return arr;
            }
            else if (sum<target){
                start++;
            }

            else if (sum>target){
                end--;
            }
        }
        return arr;
    }
}