public class Resource {

    private String name;
    private String path;
    private ResourceType rt;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ResourceType getType() {
        return rt;
    }

    public Resource(String name, String path, ResourceType rt){
        if (name.isEmpty() || path.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (rt == null){
            throw new NullPointerException();
        }
        this.name = name;
        this.path = path;
        this.rt = rt;

    }

}
