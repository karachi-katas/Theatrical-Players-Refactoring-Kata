package play;

public class Comedy extends Play {

    public Comedy(String name) {
        super(name, PLAY_TYPE);
    }

    private final static int BONUS_MAX_AUDIENCE_AMOUNT = 20;
    private final static int MINIMUM_VOLUME_CREDIT_THRESHOLD = 30;
    private final static String PLAY_TYPE = "comedy";

    @Override
    public int getAmount(int audience) {
        int thisAmount = 30000;
        thisAmount += addBonusIfApplicable(audience);
        thisAmount += 300 * audience;
        return thisAmount;
    }

    @Override
    public int addBonus(int audience) {
        return 10000 + 500 * (audience - 20);
    }

    @Override
    public boolean isAudienceLarge(int audience) {
        return audience > BONUS_MAX_AUDIENCE_AMOUNT;
    }

    @Override
    public int getVolumeCredits(int audience) {
        int volumeCredits = Math.max(audience - MINIMUM_VOLUME_CREDIT_THRESHOLD, 0);
        // add extra credit for every ten comedy attendees
        volumeCredits += Math.floor(audience / 5.00);
        return volumeCredits;
    }


}
