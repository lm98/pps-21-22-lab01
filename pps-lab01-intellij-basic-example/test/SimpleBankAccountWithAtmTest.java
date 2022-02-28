import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithATM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {
    private static final int ATM_FEE = 1;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithATM(0, accountHolder);
    }

    @Override
    double getFee() {
        return ATM_FEE;
    }
}
