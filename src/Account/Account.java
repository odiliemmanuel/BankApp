package Account;

public class Account {

    private String name;
    private String age;
    private int phoneNumber;
    private int accountNumber;
    private int balance;
    private final int pin;

    Account(String name, String age, int phoneNumber, int accountNumber, int pin){
        validateName(name);
        this.name = name;

        validateAge(age);
        validateAgeValue(age);
        this.age = age;

        validatePhoneNumberLength(phoneNumber);
        this.phoneNumber = phoneNumber;

        validateAccountNumberLength(accountNumber);
        this.accountNumber = accountNumber;

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
            balance -= balance;
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



    public int getAccountNumber() {
        int result = (int)(phoneNumber);
        return result;
    }

    public void setAccountNumber(int accountNumber) {
        validateAccountNumberLength(accountNumber);
            this.accountNumber = accountNumber;

    }




    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void changePhoneNumber(int phoneNumber) {
        validatePhoneNumberLength(phoneNumber);
        this.phoneNumber = phoneNumber;
    }




    private void validatePinLength(int pin){
        String value = Integer.toString(pin);
        if(value.length() != 4 && !value.matches("[0-9]")){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }

    private void validatePin(int pin){
//        validatePinLength(pin);
        if(this.pin != pin){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }




    private void validatePhoneNumberLength(int phoneNumber){
        String value = Integer.toString(phoneNumber);
        if(value.length() != 11 && !value.matches("[0-9]")){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }




    private void validateAccountNumberLength(int accountNumber){
        String value = Integer.toString(accountNumber);
        if(value.length() != 10 && !value.matches("[0-9]")){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }

    private void validateAccountNumber(int accountNumber){
        if(this.accountNumber != accountNumber){
            throw new IllegalArgumentException("Invalid PIN");
        }
    }




    private void validateName(String name){
        if(!name.matches("[A-Za-z\\s]")){
            throw new IllegalArgumentException("Invalid Name");
        }
    }



    private void validateAge(String age){

        if(age.length() > 3){
            throw new IllegalArgumentException("Invalid Age");
        }
    }

    private void validateAgeValue(String age){

        if(!age.matches("[0-9]")){
            throw new IllegalArgumentException("Invalid Age");
        }
    }
}

















