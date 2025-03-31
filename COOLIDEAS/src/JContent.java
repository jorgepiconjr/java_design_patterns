import java.util.HashSet;
import java.util.Set;

public abstract class JContent {

    private String title;
    private String description;
    private Set<ContentObserver> observers = new HashSet<ContentObserver>();

    public JContent(String title, String description){
        if (title.isEmpty() || description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.description = description;
        if (!observers.isEmpty()) {
            for (ContentObserver o : observers) {
                o.update(this);
            }
        }
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        if (description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.description = description;
        if (!observers.isEmpty()) {
            for (ContentObserver o : observers) {
                o.update(this);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.title = title;
        if (!observers.isEmpty()) {
            for (ContentObserver o : observers) {
                o.update(this);
            }
        }
    }
    public void addObserver(ContentObserver observer){
        if (observer == null){
            throw new NullPointerException();
        }
        observers.add(observer);
    }
    public void removeObserver(ContentObserver observer){
        if (observer == null){
            throw new NullPointerException();
        }
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }
    public int countObservers(){
        return observers.size();
    }
    public abstract String toString();

}
