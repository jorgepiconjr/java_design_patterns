public class BankAccount {

    private AccountState state;
    private double balance = 0.0;
    private double lineOfCredit;
    private String accountNumber;

    public BankAccount(String accountNumber, double lineOfCredit){
        if (accountNumber.isEmpty() || lineOfCredit < 0.0){
            throw new IllegalArgumentException();
        }
        this.state = new Positive();
        this.lineOfCredit = lineOfCredit;
        this.accountNumber = accountNumber;
    }

    public boolean payIn(double amount){
        if (amount <= 0.0){
            throw new IllegalArgumentException();
        }
        return state.payIn(amount);
    }
    public boolean payOff(double amount){
        if (amount <= 0.0){
            throw new IllegalArgumentException();
        }
        return state.payOff(amount);
    }
    public boolean close(){
        if (balance == 0.0){
            state = new Closed();
            return true;
        }
        return false;
    }
    public String getState() {
        return state.toString();
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void printBalance(){
        state.printBalance();
    }
    public void payInterest(){
        state.payInterest();
    }


    public abstract class AccountState{
        public boolean payIn(double amount){
            if (amount <= 0){
                throw new IllegalArgumentException();
            }
            return false;
        }
        public boolean payOff(double amount){
            if (amount <= 0){
                throw new IllegalArgumentException();
            }
            return false;
        }
        public String toString(){
            return state.getClass().getSimpleName();
        }
        public void payInterest(){
            throw new IllegalStateException();
        }
        public abstract void printBalance();
    }

    public class Positive extends AccountState{
        public boolean payIn(double amount){
            if (amount <= 0){
                throw new IllegalArgumentException();
            }
            balance = balance + amount;
            return true;
        }
        public boolean payOff(double amount){
            if (amount <= 0){
                throw new IllegalArgumentException();
            }
            if (amount > balance + lineOfCredit){
                return false;
            }

            balance = balance - amount;
            if (balance == -lineOfCredit){
                state = new Frozen();
            }else if (balance < 0){
                state = new Negative();
            }
            return true;
        }
        public void payInterest(){
            balance = balance + balance*0.01;
            if (balance == -lineOfCredit){
                state = new Frozen();
            }else if (balance < 0 ){
                state = new Negative();
            }
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is POSITIVE: +" + balance+".");
        }
    }
    public class Negative extends AccountState{
        public boolean payIn(double amount){
            if (amount <= 0.0){
                throw new IllegalArgumentException();
            }
            balance = balance + amount;
            if (balance >= 0){
                state = new Positive();
            }
            return true;
        }
        public boolean payOff(double amount){
            if(amount <= 0.0){
                throw new IllegalArgumentException();
            }
            if (amount > balance + lineOfCredit){
                return false;
            }

            balance = balance - amount;
            if (balance == -lineOfCredit){
                state = new Frozen();
            }
            return true;

        }
        public void payInterest(){
            balance = balance + balance*0.03;
            if (balance <= -lineOfCredit){
                state = new Frozen();
            }
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: " + balance + ".");

        }
    }
    public class Frozen extends AccountState{
        public boolean payIn(double amount){
            if (amount <= 0){
                throw new IllegalArgumentException();
            }
            balance = balance + amount;
            if (balance >= 0){
                state = new Positive();
            }else {
                state = new Negative();
            }
            return true;
        }
        public void payInterest(){
            balance = balance + balance*0.05;
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: " + balance + ". You need to pay in money.");
        }
    }
    public class Closed extends AccountState{
        @Override
        public void printBalance() {
            System.out.println("This account is CLOSED. The balance is 0.");
        }
    }


}
