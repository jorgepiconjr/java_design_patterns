import java.util.Objects;

public abstract class AbstractEnterpriseUnit implements EnterpriseNode{
    private String name;
    public AbstractEnterpriseUnit(String name){
        if(name == null){
            throw new NullPointerException();
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    @Override
    public String getName() {
        if(name == null){
            throw new NullPointerException();
        }else if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return name;
    }

}
