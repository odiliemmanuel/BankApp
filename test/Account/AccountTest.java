package Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    Account account;

    @BeforeEach
    public void startEachWith(){

        account = new Account("Barry Allen", "16", "07046731194", "7046731194", 2345);
    }


    @Test
    public void testThatMyBalanceIsZero(){

        assertEquals(0, account.checkBalance());
    }

    @Test
    public void testThatICanDeposit(){
        account.deposit(0);
        int actual = 0;
        int expected = account.checkBalance();
        assertEquals(actual, expected);

    }

    @Test
    public void testThatIDepositTwoThousand_AndBalanceIsTwoThousand(){
        assertEquals(0, account.checkBalance());
        account.deposit(2_000);

        int actual = 2_000;
        int expected = account.checkBalance();
        assertEquals(actual, expected);


    }


    @Test
    public void testThatMinimumDepositIs50(){
        assertEquals(0,account.checkBalance());
        account.deposit(50);
        int actual = 50;
        assertEquals(actual,account.checkBalance());
    }


    @Test
    public void testThatIDepositANegativeAmountAndBalanceRemainsTheSame(){
        assertEquals(0, account.checkBalance());
        account.deposit(20_000);
        int actual = 20_000;
        assertEquals(actual, account.checkBalance());

        account.deposit(-5_000);
        assertEquals(actual, account.checkBalance());


    }


    @Test
    public void testThatIfIWithdraw5000_balanceChanges(){
        assertEquals(0,account.checkBalance());

        account.deposit(3_000);
        int actual = 3_000;
        assertEquals(actual, account.checkBalance());

        account.withdraw(2_000, 2345);
        int value = 1_000;
        assertEquals(value, account.checkBalance());

    }



    @Test
    public void testThatIfIWithdraw5000_WithIncorrectPin_ErrorIsThrown(){
        assertEquals(0,account.checkBalance());

        account.deposit(3_000);
        int actual = 3_000;
        assertEquals(actual, account.checkBalance());

        assertThrows(IllegalArgumentException.class,
                    ()-> account.withdraw(2_000, 4321));
    }



    @Test
    public void testThatWithdrawalOfANegativeValueOrAmountDoesntAffectBalance(){
        assertEquals(0, account.checkBalance());
        account.deposit(9_000);

        int actual = 9_000;
        assertEquals(actual, account.checkBalance());

        account.withdraw(-2000, 2345);
        assertEquals(actual, account.checkBalance());

    }


    @Test
    public void testThatIfMyBalanceIs10k_AndIWithdraw11k_BalanceStillRemains10k(){
        assertEquals(0, account.checkBalance());
        account.deposit(10_000);

        int actual = 10_000;
        assertEquals(actual, account.checkBalance());

         account.withdraw(11_000, 2345);
         assertEquals(actual, account.checkBalance());

    }

    @Test
    public void testThatIfITransfer20k_BalanceBecomes10k(){
        assertEquals(0, account.checkBalance());
        account.deposit(30_000);

        int actual = 30_000;
        assertEquals(actual, account.checkBalance());

        Account receiverAccount = new Account("Nora West Allen", "18", "07134567438", "7134567438", 4819);

        account.transfer(20_000, 2345, receiverAccount);
        assertEquals(10_000, account.checkBalance());

    }


    @Test
    public void testThatIfITransfer20k_WithWrongPin_ErrorIsThrown(){
        assertEquals(0, account.checkBalance());
        account.deposit(30_000);

        int actual = 30_000;
        assertEquals(actual, account.checkBalance());

        Account receiverAccount = new Account("Nora West Allen", "18", "07134567438", "7134567438", 4819);

        assertThrows(IllegalArgumentException.class,
                () -> account.transfer(20_000, 2349, receiverAccount));

    }


    @Test
    public void testThatIfITransfer20k_WithWrongPin_ErrorIsThrown_AndBalanceDoesntChanges(){
        assertEquals(0, account.checkBalance());
        account.deposit(30_000);

        int actual = 30_000;
        assertEquals(actual, account.checkBalance());

        Account receiverAccount = new Account("Nora West Allen", "18", "07134567438", "7134567438", 4819);

        assertThrows(IllegalArgumentException.class,
                () -> account.transfer(20_000, 2349, receiverAccount));
        assertEquals(actual, account.checkBalance());
    }



    @Test
    public void testThatIfMyBalanceIs20k_AndITransfer30k_Balance_Remains20k(){
        assertEquals(0, account.checkBalance());
        account.deposit(20_000);
        int actual = 20_000;
        assertEquals(actual, account.checkBalance());

        Account receiverAccount = new Account("Iris West", "18", "07134567438", "7134567438", 4819);
        account.transfer(30_000, 2345, receiverAccount);
        assertEquals(20_000, account.checkBalance());

    }


    @Test
    public void testThatIfTransferANegativeAmount_BalanceRemainsTheSame(){
        assertEquals(0, account.checkBalance());
        account.deposit(20_000);

        int actual = 20_000;
        assertEquals(actual, account.checkBalance());

        Account receiverAccount = new Account("Joe West", "38", "07134532438", "7134532438", 4759);

        account.transfer(-5000, 2345, receiverAccount);
        assertEquals(actual, account.checkBalance());
    }

}