package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String accId;
	private int balance;

	//Default Constructor (생성자)
	public Account() {
		System.out.println("Default Constructor Called..");
	}
	//Constructor Overloading (생성자 중복 정의)
	public Account(String custId, String accId, int balance) {
		this.custId = custId;
		this.accId = accId;
		this.balance = balance;
	}
	//setter (값 변경)
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	//getter 
	public String getAccId() {
		return accId;
	}
	public int getBalance() {
		return balance;
	}

	public String getCustId() {
		return custId;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			//InsufficientBalanceException 강제 발생
			String errMesage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, balance);
			throw new InsufficientBalanceException(errMesage);
		}
		this.balance -= amount;
	}
	// 부모 클래스가 가진 Object의 toString(), 메서드를 제정의(Overriding)
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", accId=" + accId + ", balance=" + balance + "]";
	}

}
