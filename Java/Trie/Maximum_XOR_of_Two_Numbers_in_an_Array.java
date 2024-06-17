class Trie {
    Trie[] links;

    public Trie(){
        this.links = new Trie[2];
    }

    public boolean containsKey(int bit) {
        return this.links[bit] != null;
    }

    public void put(int bit, Trie node) {
        this.links[bit] = node;
    }

    public Trie get(int bit) {
        return this.links[bit];
    }

    public void insert(int num){
        Trie temp = this;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!temp.containsKey(bit)) temp.put(bit, new Trie());
            temp = temp.get(bit);
        }
    }

    public int findMax(int num){
        Trie temp = this;
        int maxNum = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(temp.containsKey(1 - bit)){
                maxNum |= (1 << i);
                temp = temp.get(1 - bit);
            }
            else temp = temp.get(bit);
        }

        return maxNum;
    }
}

class Maximum_XOR_of_Two_Numbers_in_an_Array {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num : nums) trie.insert(num);

        int ans = 0;
        for(int num : nums) ans = Math.max(ans, trie.findMax(num));

        return ans;
    }
}
