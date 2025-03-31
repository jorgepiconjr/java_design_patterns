import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember>{

    private Set<StaffMember> allMembers;
    private StaffMember allMembersArray[];
    private static int index;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        if(directSubordinates == null){
            throw new NullPointerException();
        }
        index = 0;
        allMembers = new TreeSet<StaffMember>();
        allMembersArray = new StaffMember[allMembers.size()];
    }
    private void findSubordinatesRecursively(StaffMember m){

    }
    @Override
    public boolean hasNext() {
        if(index < allMembers.size()) {
            return true;
        }
        return false;
    }

    @Override
    public StaffMember next() {
        if (hasNext()){
            index++;
            return allMembersArray[index-1];
        }else {
            throw new NoSuchElementException();
        }

    }
}
