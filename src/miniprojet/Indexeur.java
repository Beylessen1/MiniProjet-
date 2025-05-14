import java.util.List;
import java.util.Map;
public interface Indexeur {
    <T> Map<T, List<Nom>> indexer(List<Nom> noms);
}
