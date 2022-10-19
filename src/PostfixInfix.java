import java.util.Stack;

public class PostfixInfix {
    public static void main(String[] args) {
        String exp = "ab*c+";
        String final_result = convertPostfixInfix(exp);
        System.out.println(final_result);
    }
    static String convertPostfixInfix(String str){
        Stack<String> stack = new Stack<>();
        int length = str.length();
        for(int i = 0; i < length; ++i){
            char c = str.charAt(i);
            if(isOperator(c)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s2+c+s1+")";
                stack.push(temp);
            }else {
                stack.push(c+"");
            }
        }
        return stack.pop();
    }
    static boolean isOperator(char c){
        return switch (c){
            case '+', '-', '*', '%', '/', '^' -> true;
            default -> false;
        };
    }
}
