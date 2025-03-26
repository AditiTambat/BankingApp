
public class InvalidBalanceException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidBalanceException(String message) {
		super();
		this.message = message;
	}

	public InvalidBalanceException() {
		message = "your balance is not suffient";
	}

	@Override
	public String toString() {
		return "InvalidBalanceException [message=" + message + "]";
	}
	
}
