import java.util.SortedSet;

public class Team extends AbstractEnterpriseUnit{
    private StaffMember teamLeader;
    public Team(String name, StaffMember teamLeader){
        super(name);
        if(teamLeader == null){
            throw new NullPointerException();
        }
        this.teamLeader = teamLeader;
    }
    public StaffMember getTeamLeader(){
        return teamLeader;
    }
    public SortedSet<StaffMember> getTeamMembers(){
        // Falta implementar Iterador para usarlo aqui
        // Creo: usar iterator() en un for, para guardar en un arreglo el cual se devolvera
        // iterar solo elementos instance of Team y relacionarlo con ese teamLeader
        return teamLeader.getDirectSubordinates();
    }
}
