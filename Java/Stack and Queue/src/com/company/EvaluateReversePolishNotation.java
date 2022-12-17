// Link :- https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int i=0, num1=0, num2=0;
        Stack<Integer> st = new Stack<Integer>();
        while(i < tokens.length){
            if(tokens[i].equals("+")){
                num2 = st.pop();
                num1 = st.pop();
                st.push(num1+num2);
            }
            else if(tokens[i].equals("-")){
                num2 = st.pop();
                num1 = st.pop();
                st.push(num1-num2);
            }
            else if(tokens[i].equals("*")){
                num2 = st.pop();
                num1 = st.pop();
                st.push(num1*num2);
            }
            else if(tokens[i].equals("/")){
                num2 = st.pop();
                num1 = st.pop();
                st.push(num1/num2);
            }
            else{
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
            i++;
        }

        return st.pop();
    }
}
