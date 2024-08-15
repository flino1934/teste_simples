package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	// Ira ser testado o deposito em caso de um valor positivo
	@Test
	public void depositShouldIncreseBalanceWhenPositiveAmount() {

		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;

		Account acc = AccountFactory.createEmptyAccount();

		// Act
		acc.deposit(amount);

		// Assert
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	// Ira ser testado o deposito em caso de um valor negativo
	@Test
	public void depositShouldDonothingWhenNegativeAmout() {

		// Arrange
		double expectedValue = 100.0;
		double amount = -200.0;

		Account acc = AccountFactory.createAccount(expectedValue);

		// Act
		acc.deposit(amount);
		// Assert
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	// Ira fazer o teste do saque total
	@Test
	public void whitdrawShouldTotalAmount() {

		// Arrange
		double initialBalance = 200.0;
		double expectedValue = 0.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		// Act
		double result = acc.fullWithdraw();

		// Assert
		Assertions.assertTrue(expectedValue == result);

	}

	// ira fazer o teste com saldo positivo
	@Test
	public void withdrawShouldDecreaseWhenSufficientBalance() {
		
		// Arrange
		double initialBalance = 200.0;
		double expectedValue = 100.0;
		double amount = 100.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		//Act
		acc.withdraw(amount);
		
		//Assert
		Assertions.assertTrue(expectedValue == acc.getBalance());
		
	}
	
	//ira fazer o teste de quando o saldo não for suficiente e retornar exceptions
	@Test
	public void withdrawShouldThrowExceptionWhenInsuficientBalance() {
		
		// Arrange
		double initialBalance = 200.0;
		double amount = 1000.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		//Act and Assert
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			acc.withdraw(amount);
		});
		
		
	}

}
