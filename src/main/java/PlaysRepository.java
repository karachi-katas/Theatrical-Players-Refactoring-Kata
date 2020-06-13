import java.util.HashMap;
import java.util.Map;

public class PlaysRepository {

    private Map<String, Play> plays;
    private static PlaysRepository playRepo = new PlaysRepository();

    private PlaysRepository() {
        plays = new HashMap <String, Play>();
    }

    public static PlaysRepository getInstance() {
        return playRepo;
    }

    public void addPlay(String playId, Play play){
        plays.put(playId, play);
    }

    public Play findPlayById(String playId){
        return plays.get(playId);
    }
}
