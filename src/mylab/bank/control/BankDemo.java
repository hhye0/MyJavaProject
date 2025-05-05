package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
import javax.security.auth.login.AccountNotFoundException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // ���� ���� ����
            String savingsAcc = bank.createSavingsAccount("John Doe", 1000.0, 3.5);
            System.out.println("���� ���� ����: " + savingsAcc);

            // üũ ���� ����
            String checkingAcc = bank.createCheckingAccount("Jane Smith", 500.0, 1.5);
            System.out.println("üũ ���� ����: " + checkingAcc);

            // �Ա�
            bank.deposit(savingsAcc, 200.0);
            System.out.println("���� ���¿� 200�� �Ա�");

            // ���
            bank.withdraw(savingsAcc, 150.0);
            System.out.println("���� ���¿��� 150�� ���");

            // ���� �� ��ü
            bank.transfer(savingsAcc, checkingAcc, 100.0);
            System.out.println("���� ���¿��� üũ ���·� 100�� ��ü");

            // ���� ��� ���
            bank.printAllAccounts();

        } catch (AccountNotFoundException | InsufficientBalanceException | WithdrawalLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
