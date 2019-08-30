package LambdaWorkarounds;

public class EvaluateCheck{
    private boolean evaluated;
    
    public EvaluateCheck(){
        evaluated = false;
    }
    
    public void setEvaluated(boolean evaluateBool){
        evaluated = evaluateBool;
    }
    
    public boolean getEvaluated(){
        return evaluated;
    }
}