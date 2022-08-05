package 算法.栈;

import java.util.Stack;


public class 正确的括号 {
    // 栈
    // O(n) O(n)
    public boolean judge(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        正确的括号 solution = new 正确的括号();
        String s = "([)]";
        s = "{[]}";
        s = "()[]{}";
        System.out.println(solution.judge(s));
    }
}
