package dzierzon.gregor.junitexample;

public class InvalidPersonNameException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public InvalidPersonNameException() {}

	public InvalidPersonNameException(String s) {
		super(s);
	}

	public InvalidPersonNameException(Throwable cause) {
		super(cause);
	}

	public InvalidPersonNameException(String message, Throwable cause) {
		super(message, cause);
	}

}
