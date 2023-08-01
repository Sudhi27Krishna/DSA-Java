// Leetcode link => https://leetcode.com/problems/next-permutation/description/

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            int start = 0, end = n-1;
            while(start < end){
                swap(nums, start++, end--);
            }
            return;
        }

        for(int i=n-1; i>=0; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        int start = ind+1, end = n-1;
        while(start < end){
            swap(nums, start++, end--);
        }
    }

    void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
