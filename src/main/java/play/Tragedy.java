package play;

public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name, PLAY_TYPE);
    }

    private final static int BONUS_MAX_AUDIENCE_AMOUNT = 30;
    private final static String PLAY_TYPE = "tragedy";

    @Override
    public int getAmount(int audience) {
        int thisAmount = 40000;
        thisAmount += addBonusIfApplicable(audience);
        return thisAmount;
    }

    @Override
    public int addBonus(int audience) {
        return 1000 * (audience - BONUS_MAX_AUDIENCE_AMOUNT);
    }

    @Override
    public boolean isAudienceLarge(int audience) {
        return audience > 30;
    }
}
