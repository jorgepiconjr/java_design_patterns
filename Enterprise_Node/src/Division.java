public class Division extends AbstractUnit{
    public Division(String name){
        super(name);
    }
    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode == null) {
            throw new NullPointerException();
        }
        if(!(childNode instanceof Team)){
            throw new IllegalArgumentException();
        }
        if (!(getChildNodes().contains(childNode))){
            super.add(childNode);
            return true;
        }
        return false;
    }
}