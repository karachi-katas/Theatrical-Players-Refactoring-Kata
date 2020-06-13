package play;

public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name, "tragedy");
    }

    @Override
    public int getAmount(int audience) {
        int thisAmount = 40000;
        thisAmount += addBonusIfApplicable(audience);
        return thisAmount;
    }

    @Override
    public int addBonus(int audience) {
        return 1000 * (audience - 30);
    }

    @Override
    public boolean isAudienceLarge(int audience) {
        return audience > 30;
    }
}
