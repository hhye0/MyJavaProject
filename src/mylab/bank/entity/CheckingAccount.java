package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	public void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException{
		if (amount > withdrawalLimit) {
			String errMessage = String.format("예외 발생: 출금 한도를 초과했습니다. 한도: %d원", withdrawalLimit);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		super.withdraw(amount);
	}
}
