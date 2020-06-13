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

    public int addBonus(int audience) {
        throw new Error("unknown type: ${play.type}");
    }

    public boolean isAudienceLarge(int audience) {
        throw new Error("unknown type: ${play.type}");
    }

    public int addBonusIfApplicable(int audience) {
        return isAudienceLarge(audience) ? addBonus(audience) : 0;
    }

}
