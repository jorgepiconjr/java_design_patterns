public class Holding extends AbstractUnit{
    public Holding(String name){
        super(name);
    }
    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode == null) {
            throw new NullPointerException();
        }
        if(!(childNode instanceof Company)){
            throw new IllegalArgumentException();
        }
        if (!(getChildNodes().contains(childNode))){
            super.add(childNode);
            return true;
        }
        return false;
    }
}
