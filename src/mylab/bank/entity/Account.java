package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber; //���¹�ȣ 
	private String ownerName; //���� ������ �̸�
	protected double balance; //�ܾ�
	
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

	public void deposit(double amount) { //�Ա�
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
		}		
	}
	public void withdraw(double amount) throws InsufficientBalanceException{ //���
		if (amount > balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "���¹�ȣ: " + accountNumber + ", ������: "+ ownerName + ", �ܾ�: "+ balance;
	}
	
	
}
