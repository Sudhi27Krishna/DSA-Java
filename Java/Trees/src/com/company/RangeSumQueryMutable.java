// Leetcode link => https://leetcode.com/problems/range-sum-query-mutable/description/?envType=problem-list-v2&envId=segment-tree

class SGTree{
    int[] seg;

    public SGTree(int n){
        this.seg = new int[4*n + 1];
    }

    public void build(int ind, int low, int high, int[] arr){
        if(low == high){
            this.seg[ind] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
    }

    public int query(int ind, int low, int high, int l, int r){
        if(r < low || l > high) return 0;

        if(l <= low && high <= r) return seg[ind];

        int mid = low + (high - low) / 2;
        int right = query(2*ind+1, low, mid, l, r);
        int left = query(2*ind+2, mid+1, high, l, r);
        return right + left;
    }

    public void update(int ind, int low, int high, int idx, int val){
        if(low == high){
            seg[ind] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        if(idx <= mid) update(2*ind+1, low, mid, idx, val);
        else update(2*ind+2, mid+1, high, idx, val);
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
    }
}

class NumArray {
    SGTree sgt;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        sgt = new SGTree(n);
        sgt.build(0, 0, n-1, nums);
    }
    
    public void update(int index, int val) {
        sgt.update(0, 0, n-1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sgt.query(0, 0, n-1, left, right);
    }
}
