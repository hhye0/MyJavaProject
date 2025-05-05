package mylab.bank.exception;

public class WithdrawalLimitExceededException extends RuntimeException {
	public WithdrawalLimitExceededException(String errMessage) {
		super(errMessage);
	}
}
