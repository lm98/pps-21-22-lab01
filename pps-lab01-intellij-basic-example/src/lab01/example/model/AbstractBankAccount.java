package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;


    public AbstractBankAccount(final double balance, AccountHolder accountHolder) {
        this.balance = balance;
        this.holder = accountHolder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount - getFee();
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - getFee();
        }
    }

    private boolean isWithdrawAllowed(double amount){
        return this.balance >= amount + getFee();
    }
    abstract double getFee();

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
