// InterviewBit => https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/

public class FirstNonRepeatingCharacters {
    public String solve(String A) {
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : A.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) == 1){
                q.offer(ch);
            }
            else{
                while(!q.isEmpty() && map.get(q.peek()) > 1) q.poll();
            }
            
            if(q.isEmpty()) sb.append('#');
            else sb.append(q.peek());
        }
        
        return sb.toString();
    }
}
