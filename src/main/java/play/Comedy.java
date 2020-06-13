package play;

public class Comedy extends Play {

    public Comedy(String name) {
        super(name, "comedy");
    }

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
        return audience > 20;
    }

    @Override
    public int getVolumeCredits(int audience) {
        int volumeCredits = Math.max(audience - 30, 0);
        // add extra credit for every ten comedy attendees
        volumeCredits += Math.floor(audience / 5);
        return volumeCredits;
    }


}
