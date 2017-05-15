package may_17_data_structure;

import java.util.Stack;

/**
 * Created by DoDo on 2017-05-14.
 */
public class StackUsage {
    public static boolean judgeParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(Character c :str.toCharArray()){
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.peek().equals((char)(c-1))){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                case ']':
                    if(stack.peek().equals((char)(c-2))){
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
