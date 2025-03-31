import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class JMember implements ContentObserver{

    private Set<JTopic> topics = new TreeSet<JTopic>();
    public void subscribe(JTopic topic){
        if (topic == null){
            throw new NullPointerException();
        }
        topic.addObserver(this);
        topics.add(topic);
    }
    public void unsubscribe(JTopic topic){
        if (topic == null){
            throw new NullPointerException();
        }
        if (topics.contains(topic)){
            topic.removeObserver(this);
            topics.remove(topic);
        }
    }
    public Set<JTopic> getSubscribedTopics(){
        if (topics.isEmpty()){
            return Collections.emptySet();
        }
        return topics;
    }
    @Override
    public void update(JContent content) {
        if (content instanceof JTopic && topics.contains(content)){
            System.out.println("The topic " + ((JTopic) content).getId() + " has been updated!");
        }
    }
}