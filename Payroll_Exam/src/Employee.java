public abstract class Employee {

    private String id;

    public Employee(String id) {
        if (id.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public abstract boolean isPayday(int dayOfMonth);
    public abstract double calculatePay() throws UnpayableEmployeeException;
    public abstract double calculateDeductions();
}
