package au.com.covata.rover;



public class InstructionException extends Exception {

	private static final long serialVersionUID = 6651236087862539814L;

	public InstructionException(String message) {
		super(message);
	}

    public InstructionException(Throwable cause) {
        super(cause);
    }

    public InstructionException(String message, Throwable cause) {
        super(message, cause);
    }
}
