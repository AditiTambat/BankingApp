
public class InvalidAccountException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidAccountException(String message) {
		super();
		this.message = message;
	}

	public InvalidAccountException() {
		message = "Account not found! please create an account first.";
	}

	@Override
	public String toString() {
		return "InvalidAccountException [message=" + message + "]";
	}
	
}
