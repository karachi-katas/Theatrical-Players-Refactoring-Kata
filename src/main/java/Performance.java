import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Performance {

    private Play play;
    public int audience;
    public Map<String, Supplier<Integer>> baseAmount;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
        this.baseAmount = new HashMap<>();
        this.baseAmount.put("tragedy",()->{
            int thisAmount = 40000;
            if (audience > 30) {
                thisAmount += 1000 * (audience - 30);
            }
            return thisAmount;
        });
        this.baseAmount.put("comedy",()->{
            int thisAmount = 30000;
            if (audience > 20) {
                thisAmount += 10000 + 500 * (audience - 20);
            }
            thisAmount += 300 * audience;
            return thisAmount;
        });

    }

    public int getThisAmount() {
       return baseAmount.getOrDefault(play.type, () ->{
            throw new Error("unknown type: ${play.type}");
        }).get();
    }

    public int getVolumeCredit(){
        int volumeCredits = Math.max(audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(play.type)) volumeCredits += Math.floor(audience / 5);
        return volumeCredits;
    }

    public String getName(){
        return this.play.name;
    }
}
