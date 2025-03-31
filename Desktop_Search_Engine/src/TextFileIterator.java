import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TextFileIterator implements Iterator<String> {
    private List<String> words = new ArrayList<>();
    int index = 0;
    public TextFileIterator(Resource res){
        if (res == null){
            throw new NullPointerException();
        }
        String[] array = getAsString(res).split(" ");
        for (int i = 0; i < array.length ; i++) {
            if (array[i].contains("!")){
                array[i] = array[i].replace("!","");
            }
            if (array[i].contains(".")){
                array[i] = array[i].replace(".","");
            }
            if (array[i].contains("-\n")){
                array[i] = array[i].replace("-\n","");
            }
            if (array[i].contains("\n")) {
                String[] aux = array[i].split("\n");
                words.add(aux[0]);
                words.add(aux[1]);
            }else{
                words.add(array[i]);
            }
        }
    }
    @Override
    public boolean hasNext() {
        return index < words.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            index++;
            return words.get(index-1);
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String getAsString(Resource res){
        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    }


}
