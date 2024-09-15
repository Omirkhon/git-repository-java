package JUnit.example2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        assertEquals(0, account.getAmount());
        assertEquals("KZT", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("a", "b");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccount account = new BankAccount("a", "b");
        String[] accountsName = account.getFullName();
        assertArrayEquals(account.getFullName(), accountsName);
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("a", "b");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.getAmount());
        assertNull(account.getCurrency());
        assertEquals("Счёт не активирован.", exception.getMessage());
    }

    @Test
    public void shouldWithdrawWhenActivated() {
        BankAccount account = new BankAccount("a", "b");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(500));
        assertEquals("Счет не активирован.", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenBlocked() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        account.block();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(500));
        assertEquals("Счет заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenAccHasLessThanGivenAmount() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(500));
        assertEquals("Не достаточно средств на счету.", exception.getMessage());
        assertEquals(0, account.getAmount());
    }

    @Test
    public void shouldNotWithdrawWhenAmountIsZero() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(0));
        assertEquals("Введена некоректная сумма.", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenAmountIsLessThanZero() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(-125));
        assertEquals("Сумма не может быть отрицательной.", exception.getMessage());
    }

    @Test
    public void shouldWithdrawWhenAllIsMet() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        account.deposit(800);
        account.withdraw(500);
        assertEquals(300, account.getAmount());
    }

    @Test
    public void shouldTransferWhenSenderAccActivated() {
        BankAccount account = new BankAccount("a", "b");
        BankAccount otherAccount = new BankAccount("c", "d");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 500));
        assertEquals("Счет отправителя не активирован.", exception.getMessage());
    }

    @Test
    public void shouldNotTransferWhenSenderAccBlocked() {
        BankAccount account = new BankAccount("a", "b");
        BankAccount otherAccount = new BankAccount("c", "d");
        account.activate("KZT");
        account.block();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 500));
        assertEquals("Счет отправителя заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldNotTransferWhenSenderAccHasLessThanGivenAmount() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        BankAccount otherAccount = new BankAccount("c", "d");
        otherAccount.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 500));
        assertEquals("Не достаточно средств на счету отправителя.", exception.getMessage());
    }

    @Test
    public void shouldTransferWhenRecipientAccActivated() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        BankAccount otherAccount = new BankAccount("c", "d");
        account.deposit(500);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 500));
        assertEquals("Счет получателя не активирован.", exception.getMessage());
    }

    @Test
    public void shouldNotTransferWhenRecipientAccBlocked() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        BankAccount otherAccount = new BankAccount("c", "d");
        otherAccount.activate("KZT");
        otherAccount.block();
        account.deposit(500);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 500));
        assertEquals("Счет получателя заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldNotTransferWhenAmountIsZero() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        BankAccount otherAccount = new BankAccount("c", "d");
        otherAccount.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, 0));
        assertEquals("Введена некоректная сумма.", exception.getMessage());
    }

    @Test
    public void shouldNotTransferWhenAmountIsLessThanZero() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        BankAccount otherAccount = new BankAccount("c", "d");
        otherAccount.activate("KZT");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.transfer(otherAccount, -250));
        assertEquals("Сумма не может быть отрицательной.", exception.getMessage());
    }
}
