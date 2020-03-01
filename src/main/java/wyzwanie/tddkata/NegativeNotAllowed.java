package wyzwanie.tddkata;

class NegativeNotAllowed extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NegativeNotAllowed(String message) {
        super(message);
    } 
}