import may_17_data_structure.LinearList;
import may_17_data_structure.StackUsage;

/**
 * Created by DoDo on 2017-05-14.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("{,}, (,), [,]:" +(int)'{'+","+(int)'}'+","+(int)'('+","+(int)')'+(int)'['+","+(int)']');
        System.out.printf("Str: {{(})} = %b %n",StackUsage.judgeParenthesis("{{(})}"));
        System.out.printf("Str: {{()}} = %b %n",StackUsage.judgeParenthesis("{{()}}"));
        System.out.printf("Str: {(())} = %b %n",StackUsage.judgeParenthesis("{(())}"));
        System.out.printf("Str: (((() = %b %n",StackUsage.judgeParenthesis("(((()"));
    }
}
