import java.util.HashMap;
import java.util.Map;

public class PlaysRepository {

    private Map<String, Play> plays;
    private static PlaysRepository playRepo;

    private PlaysRepository() {
        plays = new HashMap <String, Play>();
    }

    public static PlaysRepository getInstance() {

        if (playRepo == null) {
            playRepo = new PlaysRepository();
        }
        return playRepo;
    }

    public void addPlay(String playId, Play play){
        plays.put(playId, play);
    }

    public Play findPlayById(String playId){
        return plays.get(playId);
    }
}
