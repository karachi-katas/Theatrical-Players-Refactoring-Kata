package play;

public class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public int getAmount(int audience){
        throw new Error("unknown type: ${play.type}");
    }

    public int getVolumeCredits(int audience){
        return Math.max(audience - 30, 0);
    }
}
