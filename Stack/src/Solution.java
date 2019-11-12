import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 */
class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
