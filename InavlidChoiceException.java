package customException;

@SuppressWarnings("serial")
public class InavlidChoiceException extends RuntimeException {
	
	private String message;
	
	public InavlidChoiceException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

}
