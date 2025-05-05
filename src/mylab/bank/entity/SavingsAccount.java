package mylab.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate; //이자율
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
		public double getInterestRate() {
		return interestRate;
	}
	

	public void applyInterest() {
		double interest = balance * (interestRate / 100);
		deposit(interest);
		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance);
	}

}
