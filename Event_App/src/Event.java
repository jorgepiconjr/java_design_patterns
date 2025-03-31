import java.lang.Comparable;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private String title;
    private EventCategory category;

    public Event(String title, EventCategory category){
        if (title.equals("")){
            throw new IllegalArgumentException();
        }
        if(category == null){
            throw new NullPointerException();
        }
        this.title = title;
        this.category = category;
    }

    public String getTitle(){
        return title;
    }

    public EventCategory getCategory(){
        return category;
    }
    @Override
    public int compareTo(Event o){
        int aux = title.compareTo(o.title);
        if (aux != 0){
            return aux;
        }else {
            return category.compareTo(o.category);
        }
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Event){
            Event e = (Event) o;
            return title.equals(e.title) && category.equals(e.category);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, category);
    }
}