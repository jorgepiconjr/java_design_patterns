import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlainTextCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        if (res == null){
            throw new NullPointerException();
        }

        Set<String> words = new HashSet<>();
        TextFileIterator iter = new TextFileIterator(res);

        while (iter.hasNext()){
            words.add(iter.next());
        }

        return words;
    }

}