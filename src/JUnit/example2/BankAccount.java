package JUnit.example2;

public class BankAccount {

    private boolean isBlocked = false;
    private Integer amount;
    private String currency;

    private final String firstName;
    private final String secondName;

    public BankAccount(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void activate(String currency) {
        this.amount = 0;
        this.currency = currency;
    }

    public Integer getAmount() {
        if (amount == null) {
            throw new IllegalStateException("Счёт не активирован.");
        }
        return this.amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String[] getFullName() {
        return new String[]{firstName, secondName};
    }

    public void withdraw(int amount) {
        if (this.amount == null) {
            throw new IllegalStateException("Счет не активирован.");
        }
        if (isBlocked) {
            throw new IllegalStateException("Счет заблокирован.");
        }
        if (this.amount < amount) {
            throw new IllegalStateException("Не достаточно средств на счету.");
        }
        if (amount == 0) {
            throw new IllegalStateException("Введена некоректная сумма.");
        }
        if (amount < 0) {
            throw new IllegalStateException("Сумма не может быть отрицательной.");
        }
        this.amount -= amount;
    }

    public void transfer(BankAccount otherAccount, int amount) {
        if (this.amount == null) {
            throw new IllegalStateException("Счет отправителя не активирован.");
        }
        if (isBlocked) {
            throw new IllegalStateException("Счет отправителя заблокирован.");
        }
        if (this.amount < amount) {
            throw new IllegalStateException("Не достаточно средств на счету отправителя.");
        }
        if (otherAccount.amount == null) {
            throw new IllegalStateException("Счет получателя не активирован.");
        }
        if (otherAccount.isBlocked) {
            throw new IllegalStateException("Счет получателя заблокирован.");
        }
        if (amount == 0) {
            throw new IllegalStateException("Введена некоректная сумма.");
        }
        if (amount < 0) {
            throw new IllegalStateException("Сумма не может быть отрицательной.");
        }
        this.amount -= amount;
        otherAccount.amount += amount;
    }
}
