import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PayrollDispositionImpl implements PayrollDisposition{

  private Map<Employee , Double> payments = new TreeMap<>();

    public PayrollDispositionImpl() {
    }
    public double getTotal(){
        double total = 0.0;
        for (double salary : payments.values()) {
            total += salary;
        }
        return total;
    }
    public double getAverage(){
        if (payments.size() > 0){
            return getTotal()/payments.size();
        }
        return 0;
    }
    public Map<Employee,Double> getPayments(){
        return payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        if (empl == null){
            throw new NullPointerException();
        }
        if (payment < 0 ){
            throw new IllegalArgumentException();
        }
        payments.put(empl,payment);
    }
}
