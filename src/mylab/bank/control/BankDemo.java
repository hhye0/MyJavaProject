package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
import javax.security.auth.login.AccountNotFoundException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // 저축 계좌 생성
            String savingsAcc = bank.createSavingsAccount("John Doe", 1000.0, 3.5);
            System.out.println("저축 계좌 생성: " + savingsAcc);

            // 체크 계좌 생성
            String checkingAcc = bank.createCheckingAccount("Jane Smith", 500.0, 1.5);
            System.out.println("체크 계좌 생성: " + checkingAcc);

            // 입금
            bank.deposit(savingsAcc, 200.0);
            System.out.println("저축 계좌에 200원 입금");

            // 출금
            bank.withdraw(savingsAcc, 150.0);
            System.out.println("저축 계좌에서 150원 출금");

            // 계좌 간 이체
            bank.transfer(savingsAcc, checkingAcc, 100.0);
            System.out.println("저축 계좌에서 체크 계좌로 100원 이체");

            // 계좌 목록 출력
            bank.printAllAccounts();

        } catch (AccountNotFoundException | InsufficientBalanceException | WithdrawalLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
