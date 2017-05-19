package may_17_data_structure;

import java.util.Stack;

/**
 * Created by DoDo on 2017-05-14.
 */
public class StackUsage {
    public static boolean judgeParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(char c :str.toCharArray()){
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                    c = (char) (c -1);
                case ')':
                    if(stack.peek().equals((char)(c-1))){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }
}
