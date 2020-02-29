package wyzwanie.tddkata;

public class NegativeNotAllowed extends Exception{
    public NegativeNotAllowed(String errorMessage){
        super("NegativeNotAllowed(\""+errorMessage+"\")");
    }
}
