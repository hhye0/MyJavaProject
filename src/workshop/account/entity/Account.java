package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String accId;
	private int balance;

	//Default Constructor (������)
	public Account() {
		System.out.println("Default Constructor Called..");
	}
	//Constructor Overloading (������ �ߺ� ����)
	public Account(String custId, String accId, int balance) {
		this.custId = custId;
		this.accId = accId;
		this.balance = balance;
	}
	//setter (�� ����)
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
	
	//�Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}
	//���
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			//InsufficientBalanceException ���� �߻�
			String errMesage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, balance);
			throw new InsufficientBalanceException(errMesage);
		}
		this.balance -= amount;
	}
	// �θ� Ŭ������ ���� Object�� toString(), �޼��带 ������(Overriding)
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", accId=" + accId + ", balance=" + balance + "]";
	}

}
