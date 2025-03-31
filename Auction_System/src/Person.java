public class Person {

    private String name;

    public Person(String name){
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }
}
