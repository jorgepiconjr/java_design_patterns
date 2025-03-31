import java.util.*;

public class Index {

    private Map<String,List<Resource>> index;

    public Index(){
        index = new TreeMap<String, List<Resource>>();
    }
    public void add(Resource res){
        if (res==null){
            throw new NullPointerException();
        }
        Set<String> set = res.getType().getCollector().getKeywords(res);
        for (String s : set) {
            if (!index.containsKey(s)){
                List<Resource> list = new ArrayList<>();
                list.add(res);
                index.put(s,list);
            }else {
                index.get(s).add(res);
            }
        }

    }
    public List<Resource> getResources(String keyword){
        if (keyword.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (!index.containsKey(keyword)){
            return new LinkedList<>();
        }else {
            return index.get(keyword);
        }
    }

}