package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    // 생성자 추가 (accounts 리스트 초기화)
    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1;  // 계좌 번호 시작값
    }

    // 저축 계좌 생성
    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accNum, ownerName, balance, interestRate));
        return accNum;
    }

    public String createCheckingAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accNum, ownerName, balance, interestRate));
        return accNum;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream().filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst().orElseThrow(()-> new AccountNotFoundException("예외 발생: 계좌번호 "+ accountNumber +"에 해당하는 계좌를 찾을 수 없습니다."));
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, WithdrawalLimitExceededException, InsufficientBalanceException {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
    }

    public void printAllAccounts() {
        accounts.forEach(acc -> System.out.println(acc));
    }
}
