package lab01.example.model;

public class SimpleBankAccountWithATM extends AbstractBankAccount {

    private static final double ATM_FEE = 1;

    public SimpleBankAccountWithATM(double balance, AccountHolder accountHolder) {
        super(balance, accountHolder);
    }

    @Override
    double getFee(){
        return this.ATM_FEE;
    }

}
