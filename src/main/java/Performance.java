import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class Performance {

    private Play play;
    public Audience audience;
    public Map<String, Integer> baseAmount;

    public Performance(Play play, Audience audience) {
        this.play = play;
        this.audience = audience;
        this.baseAmount = new HashMap<>();
        this.baseAmount.put("tragedy", 40000);
        this.baseAmount.put("comedy", 30000);
    }

    public int getThisAmount() {
        return Optional.ofNullable(baseAmount.get(play.type)).orElseThrow(() -> new Error("unknown type: ${play.type}")) + audience.getExtraAmount(play.type);
    }

    public int getVolumeCredit(){
        int volumeCredits = Math.max(audience.count - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(play.type)) volumeCredits += Math.floor(audience.count / 5);
        return volumeCredits;
    }

    public String getName(){
        return this.play.name;
    }

    public int getAudienceCount(){
        return this.audience.count;
    }
}
