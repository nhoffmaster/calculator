import com.fathzer.soft.javaluator.DoubleEvaluator;

public class Parser{
    public static Double parse(String expression){
        DoubleEvaluator evaluator = new DoubleEvaluator();
        char[] expressionArr = expression.toCharArray();
        String newExpr = "";
        for(char i : expressionArr){
            if(i != '\n'){
                newExpr += i;
            }
        }
        Double result = evaluator.evaluate(newExpr);
        return result;
    }
}
