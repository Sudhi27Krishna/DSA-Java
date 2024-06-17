public class Trie {

    Trie[] links;
    boolean flag;

    public Trie(){
        this.links = new Trie[26];
        this.flag = false;
    }

    public boolean containsKey(char ch) {
        return this.links[ch - 'a'] != null;
    }

    public void put(char ch, Trie node) {
        this.links[ch - 'a'] = node;
    }

    public Trie get(char ch) {
        return this.links[ch - 'a'];
    }

    public void setEnd() {
        this.flag = true;
    }

    public boolean isEnd() {
        return this.flag;
    }

    public void insert(String word){
        Trie temp = this;
         for(char ch : word.toCharArray()) {
             if (!temp.containsKey(ch)) temp.put(ch, new Trie());
             temp = temp.get(ch);
         }
         temp.setEnd();
    }

    public boolean search(String word){
        Trie temp = this;
         for(char ch : word.toCharArray()){
             if(!temp.containsKey(ch)) return false;
             temp = temp.get(ch);
         }
         return temp.isEnd();
    }

    public boolean startsWith(String prefix){
        Trie temp = this;
        for(char ch : prefix.toCharArray()){
            if(!temp.containsKey(ch)) return false;
            temp = temp.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting words: Striver, Striving, String, Strike, Sudhi");
        String[] words = {"striver", "striving", "string", "strike", "sudhi"};
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with sdh: " +
                (trie.startsWith("sdh") ? "True" : "False"));
    }
}
