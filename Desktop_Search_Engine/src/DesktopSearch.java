import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesktopSearch {

    private Map<String,ResourceType> types;
    private Index index;

    public  DesktopSearch(){
        this.types = new TreeMap<>();
        this.index = new Index();
    }
    public void registerType(String extension, ResourceType type){
        if (type == null){
            throw new NullPointerException();
        }
        if (extension.isEmpty()){
            throw new IllegalArgumentException();
        }
        types.put(extension,type);
    }
    public ResourceType getType(String extension){
        return types.get(extension);
    }
    public void unregisterType(String extension){
        if (extension.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (types.containsKey(extension)){
            types.remove(extension);
        }
    }
    public void registerResource(Resource res){
        if (res == null){
            throw new NullPointerException();
        }
        index.add(res);
    }
    public List<Resource> processRequest(String request){
        if (request.isEmpty()){
            throw new IllegalArgumentException();
        }
        return index.getResources(request);
    }


}