package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber; //계좌번호 
	private String ownerName; //계좌 소유자 이름
	protected double balance; //잔액
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) { //입금
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
		}		
	}
	public void withdraw(double amount) throws InsufficientBalanceException{ //출금
		if (amount > balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: "+ ownerName + ", 잔액: "+ balance;
	}
	
	
}
