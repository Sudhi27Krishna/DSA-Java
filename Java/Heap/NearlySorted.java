// GFG link => https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1

class NearlySorted
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int elm : arr){
            pq.offer(elm);
            if(pq.size() > k) ans.add(pq.poll());
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        return ans;
    }
}
