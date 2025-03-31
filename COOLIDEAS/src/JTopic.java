public class JTopic extends JContent implements Comparable<JTopic>{

    private int id;


    public JTopic(String tittle, String description, int id){
        super(tittle,description);
        if (id < 0 ){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Topic" + ": " + getTitle() + "\n" + getDescription();
    }

    @Override
    public int compareTo(JTopic topic) {
        return Integer.compare(id , topic.id);
    }
}
