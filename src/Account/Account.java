package Account;

public class Account {

    private String name;
    private String age;
    private String phoneNumber;
    private String accountNumber;
    private int balance;
    private final int pin;

    Account(String name, String age, String phoneNumber, String accountNumber, int pin){
        validateName(name);
        this.name = name;

        validateAge(age);
        validateAgeValue(age);
        this.age = age;

        validatePhoneNumberLength(phoneNumber);
        this.phoneNumber = phoneNumber;

        validateAccountNumberLength(accountNumber);
        this.accountNumber = accountNumber;

        validatePinLength(pin);
        this.pin = pin;
    }

    public int checkBalance(){
        return balance;
    }


    public void deposit(int amount){
        if(amount >= 50){
            balance += amount;
        }

    }


    public void withdraw(int amount, int pin){
        validatePin(pin);
        validatePinLength(pin);
        if(amount >= 500 && amount <= balance){
            balance -= amount;
        }

    }


    public void transfer(int amount, int pin, Account receiverAccount){
        withdraw(amount, pin);
        receiverAccount.deposit(amount);
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        validateAge(age);
        validateAgeValue(age);
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }



    public String getAccountNumber() {
        String result = phoneNumber.substring(1);
        return result;
    }

    public void setAccountNumber(String accountNumber) {
        validateAccountNumberLength(accountNumber);
            this.accountNumber = accountNumber;

    }




    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void changePhoneNumber(String phoneNumber) {
        validatePhoneNumberLength(phoneNumber);
        this.phoneNumber = phoneNumber;
    }




    private void validatePinLength(int pin){
        String value = Integer.toString(pin);
        if(value.length() != 4 && !value.matches("[0-9]+")){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }

    private void validatePin(int pin){
        if(this.pin != pin){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }




    private void validatePhoneNumberLength(String phoneNumber){

        if(phoneNumber.length() != 11 && !phoneNumber.matches("^[0-9]+$")){
            throw new IllegalArgumentException("Invalid PIN");
        }

    }




    private void validateAccountNumberLength(String accountNumber){

        if(accountNumber.length() != 10 && !accountNumber.matches("[0-9]+")){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }


    private void validateAccountNumber(String accountNumber){
        if(!this.accountNumber.equals(accountNumber)){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }




    private void validateName(String name){
        if(!name.matches("[A-Za-z\\s]+")){
            throw new IllegalArgumentException("Invalid Name");
        }
    }



    private void validateAge(String age){

        if(age.length() > 3){
            throw new IllegalArgumentException("Invalid Age");
        }
    }

    private void validateAgeValue(String age){

        if(!age.matches("[0-9]+")){
            throw new IllegalArgumentException("Invalid Age");
        }
    }
}

















