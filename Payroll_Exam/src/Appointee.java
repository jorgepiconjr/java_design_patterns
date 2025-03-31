public class Appointee extends Employee {

    private int payday;
    private int hoursPermonth;
    private double payPerHour;

    public Appointee(String id, int payday, int hoursPermonth, double payPerHour) {
        super(id);
        if (payday < 1 || payday > 30 || hoursPermonth < 1 || payPerHour <= 0){
            throw new IllegalArgumentException();
        }
        this.payday = payday;
        this.hoursPermonth = hoursPermonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 30){
            throw new IllegalArgumentException();
        }
        if (dayOfMonth == payday){
            return true;
        }else return false;
    }

    @Override
    public double calculatePay() {
        if(isPayday(payday)){
            return hoursPermonth*payPerHour;
        }
        return 0;
    }

    @Override
    public double calculateDeductions() {
        return calculatePay()*0.4;
    }
}
