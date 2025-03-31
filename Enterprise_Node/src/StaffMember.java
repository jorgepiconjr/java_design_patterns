import java.util.*;

public class StaffMember implements EnterpriseNode,java.lang.Comparable<StaffMember>{
    private String name;
    private String job;
    private SortedSet<StaffMember> directSubordinates = new TreeSet<StaffMember>();

    public StaffMember(String name, String job){
        if (name == null) {
            throw new NullPointerException();
        }
        if(name.isEmpty() || job.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.job = job;
    }
    public String getJob(){
        return job;
    }
    @Override
    public String getName(){
        return name;
    }
    public int compareTo(StaffMember o){
        return name.compareTo(o.name);
    }
    public boolean addDirectSubordinate(StaffMember subordinate){
        if (subordinate == null){
            throw new NullPointerException();
        }
        directSubordinates.add(subordinate);
        return true;
    }
    public boolean removeDirectSubordinate(StaffMember subordinate){
        if (subordinate == null){
            throw new NullPointerException();
        }
        if (directSubordinates.isEmpty()){
            return false;
        }
        directSubordinates.remove(subordinate);
        return true;
    }
    public SortedSet<StaffMember> getDirectSubordinates(){
        if (directSubordinates.isEmpty()){
            return Collections.emptySortedSet();
        }
        return directSubordinates;
    }
    public String toString(){
        return name;
    }

}
