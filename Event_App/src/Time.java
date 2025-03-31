public class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute){
        if ( hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59){
            this.hour = hour;
            this.minute = minute;
        }else {
            throw new IllegalArgumentException();
        }

    }

    public int getHour() {
        return hour;
    }
    public int getMinute(){
        return minute;
    }

}