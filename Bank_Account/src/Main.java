class Main{
    public static void main(String[] args) {
        BankAccount c1 = new BankAccount("001",100 );

        System.out.print("toString: "); c1.toString();
        System.out.print("Balance: "); c1.printBalance();

        c1.payIn(100);
        c1.printBalance();
    }
}