import java.util.List;

public class Payroll {

    private PayrollDisposition disposition;
    private int payday;

    public Payroll(PayrollDisposition disposition, int payday) {
        if (disposition == null){
            throw new NullPointerException();
        }
        if (payday < 1 || payday > 30){
            throw new IllegalArgumentException();
        }
        this.disposition = disposition;
        this.payday = payday;
    }
    public void doPayroll(PayrollDB db){
        if (db == null){
            throw new NullPointerException();
        }
        for (Employee e : db.getEmployeeList()) {
            if (e.isPayday(payday)){
                try {
                    disposition.sendPayment(e, e.calculatePay() - e.calculateDeductions());
                } catch (UnpayableEmployeeException ex) {
                        System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
}
