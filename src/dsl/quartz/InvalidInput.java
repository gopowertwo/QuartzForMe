package dsl.quartz;

public class InvalidInput extends Exception {

	/**
	 *	Exception for invalid values for the cron expression
	 */
	
	private static final long serialVersionUID = 1L;

	public InvalidInput(String msg) {
		super(msg);
	}

}
