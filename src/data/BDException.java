package data;

public class BDException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BDException(String errorMessage) {
		super(errorMessage);
	}

}
