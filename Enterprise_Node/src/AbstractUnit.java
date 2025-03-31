import java.util.*;
import java.util.Objects;

public abstract class AbstractUnit extends AbstractEnterpriseUnit implements Comparable<AbstractEnterpriseUnit>{
    private Set<AbstractEnterpriseUnit> childNodes;
    public AbstractUnit(String name){
        super(name);
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        childNodes = new TreeSet<AbstractEnterpriseUnit>();
    }
    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode == null) {
            throw new NullPointerException();
        }
        if(!(childNode instanceof AbstractEnterpriseUnit)){
            throw new IllegalArgumentException();
        }
        if (!(childNodes.contains(childNode))){
            childNodes.add(childNode);
            return true;
        }
        return false;
    }
    public boolean remove(AbstractEnterpriseUnit childNode){
        if (childNode == null) {
            throw new NullPointerException();
        }
        if(!(childNode instanceof AbstractEnterpriseUnit)){
            throw new IllegalArgumentException();
        }
        if (childNodes.contains(childNode)){
            childNodes.remove(childNode);
            return true;
        }
        if (!(childNodes.contains(childNode))) {
            return false;
        }
        return true;
    }
    public Set<AbstractEnterpriseUnit> getChildNodes(){
        if (childNodes.isEmpty()){
            return Collections.emptySortedSet();
        }
        return childNodes;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEnterpriseUnit e = (AbstractEnterpriseUnit) o;
        return this.getName().equals(e.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    @Override
    public int compareTo(AbstractEnterpriseUnit o) {
        if (this.getName().equals(o.getName())){
            return 0;
        }else {
            return 1;
        }
    }
}
