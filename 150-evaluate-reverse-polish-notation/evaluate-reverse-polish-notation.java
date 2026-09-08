class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;

        for (String token : tokens) {
        
            if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1) {
                int b = stack[--top]; 
                int a = stack[--top]; 

                switch (token.charAt(0)) {
                    case '+': stack[top++] = a + b; break;
                    case '-': stack[top++] = a - b; break;
                    case '*': stack[top++] = a * b; break;
                    case '/': stack[top++] = a / b; break; 
                }
            } else {
                stack[top++] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}