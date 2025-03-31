import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventCatalogImpl extends java.util.TreeMap<Event , Set<Time>> implements EventCatalog{

    private Map<Event, Set<Time>> catalog = new TreeMap<Event, Set<Time>>();

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (tSet == null || tSet.contains(null)){
            throw new NullPointerException();
        }
        if (!catalog.containsKey(e)){
            catalog.put(e,tSet);
            return true;
        }
        return false;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null || t == null){
            throw new NullPointerException();
        }
        if (!catalog.containsKey(e)){
            return false;
        }

        for (Time time : catalog.get(e)) {
            if (time.getHour() == t.getHour() && time.getMinute() == t.getMinute()){
                return false;
            }
        }
        return catalog.get(e).add(t);

    }

    @Override
    public Set<Event> getAllEvents() {
        return catalog.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e == null){
            throw new NullPointerException();
        }
        if (catalog.containsKey(e)){
            return catalog.get(e);
        }
        return null;
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if (category == null){
            throw new NullPointerException();
        }
        Map<Event, Set<Time>> aux = new TreeMap<Event, Set<Time>>();
        for (Event e : catalog.keySet()) {
            if (e.getCategory().equals(category)){
                aux.put(e,catalog.get(e));
            }
        }
        if (aux.isEmpty()){
            return Collections.emptyMap();
        }else {
            return aux;
        }
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null){
            throw new NullPointerException();
        }
        if (catalog.containsKey(e)){
            return catalog.remove(e);
        }
        return null;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null || t == null){
            throw new NullPointerException();
        }
        if (catalog.containsKey(e) && catalog.get(e).contains(t)){
            return catalog.get(e).remove(t);
        }
        return false;
    }
}