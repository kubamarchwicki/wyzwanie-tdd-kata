package wyzwanie.tddkata;

public class NegativeNotAllowed extends RuntimeException{
    public NegativeNotAllowed(String errorMessage){
        super("NegativeNotAllowed(\""+errorMessage+"\")");
    }
}
