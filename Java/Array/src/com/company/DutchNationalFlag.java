// Leetcode link => https://leetcode.com/problems/sort-colors/description/
class DutchNationalFlag {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        while(low <= mid && mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid++, low++);
            }
            else if(nums[mid] == 1) mid++;
            else{
                swap(nums, high--, mid);
            }
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
