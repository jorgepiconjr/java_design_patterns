import java.util.*;

public class JIdeaPool {

    private Map<JTopic , Set<JIdea>> pool;

    public JIdeaPool(){
        this.pool = new TreeMap<JTopic , Set<JIdea>>();
    }
    public boolean add(JTopic topic){
        if (topic == null){
            throw new NullPointerException();
        }
        if (!pool.containsKey(topic)){
            pool.put(topic, new TreeSet<JIdea>());
            return true;
        }
        return false;
    }
    public void add(JIdea idea,JTopic topic){
        if (topic == null || idea == null){
            throw new NullPointerException();
        }
        JIdea i = getIdea(idea.getTitle());

        if (i == null || i == idea){
            if (pool.containsKey(topic)){
                pool.get(topic).add(idea);
            }else {
                Set<JIdea> newSet = new TreeSet<>();
                newSet.add(idea);
                pool.put(topic,newSet);
            }
        }
    }
    public boolean remove(JTopic topic){
        if (topic == null){
            throw new NullPointerException();
        }
        if (pool.containsKey(topic)){
            pool.remove(topic);
            return true;
        }
        return false;
    }
    public boolean remove(JIdea idea){
        if (idea == null){
            throw new NullPointerException();
        }
        if (pool.values().isEmpty()){
            return false;
        }
        boolean ideaRemoved = false;
        for (Set<JIdea> s : pool.values()) {
            if (s.contains(idea)){
                ideaRemoved = s.remove(idea);
            }
        }
        return ideaRemoved;
    }
    public JIdea getIdea(String title){
        if (title.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (pool.values().isEmpty()){
            return null;
        }
        for (Set<JIdea> s : pool.values()) {
            for (JIdea i : s) {
                if (i.getTitle().equals(title)){
                    return i;
                }
            }
        }
        return null;
    }
    public int numberOfTopics(){
        return pool.size();
    }
    public int numberOfIdeas(){
        Set<JIdea> historial = new TreeSet<JIdea>();

        if (pool.values().isEmpty()){
            return 0;
        }
        for (Set<JIdea> s : pool.values()) {
            for (JIdea i : s) {
                historial.add(i);
            }
        }
        return historial.size();
    }
    public void removeDeclined(){
        for (JTopic t : pool.keySet()){
            Set<JIdea> set = new TreeSet<JIdea>();
            for (JIdea i : pool.get(t)) {
                if (!i.isDeclined()){
                    set.add(i);
                }
            }
            pool.put(t,set);
        }
    }
    public void removeReleased(){
        for (JTopic t : pool.keySet()){
            Set<JIdea> set = new TreeSet<JIdea>();
            for (JIdea i : pool.get(t)) {
                if (!i.isReleased()){
                    set.add(i);
                }
            }
            pool.put(t,set);
        }
    }


}
