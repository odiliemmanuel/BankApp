package Account;

import java.util.ArrayList;

public class Bank {
    private ArrayList <Account> accounts =  new ArrayList<>();
    private int numberOfAccounts;

    public Account createAccount(String name, String age, String phoneNumber, String accountNumber, int pin){
        Account account = new Account(name, age, phoneNumber, accountNumber, pin);
        accounts.add(account);
        numberOfAccounts ++;

        return account;
    }

    public String accountNumber(){
        return "00" + numberOfAccounts ++;
    }

    public Acc


 }
