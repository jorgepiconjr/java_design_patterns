import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector{

    @Override
    public Set<String> getKeywords(Resource res) {
        if (res == null){
            throw new NullPointerException();
        }
        Set<String> words = new HashSet<>();
        words.add(res.getName());
        return words;
    }
}
