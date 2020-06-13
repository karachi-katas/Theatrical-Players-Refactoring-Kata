package play;

public class MiscellaneousPlay extends Play {
    public MiscellaneousPlay(String name, String type) {
        super(name, type);
    }

    @Override
    public int getAmount(int audience){
        throw new Error("unknown type: ${play.type}");
    }

    @Override
    public int getVolumeCredits(int audience){
        return Math.max(audience - 30, 0);
    }

    @Override
    public int addBonus(int audience) {
        return 0;
    }

    @Override
    public boolean isAudienceLarge(int audience) {
        return false;
    }

    @Override
    public int addBonusIfApplicable(int audience) {
        return 0;
    }
}
