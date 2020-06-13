public class ComedyPlay extends Play {

    public ComedyPlay(String name, String type) {
        super(name, type);
    }

    @Override
    int getBaseAmount() {
        return 30000;
    }

    @Override
    int totalAmountBasedOnAudience(int audience) {
        int thisAmount = getBaseAmount();
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;
        return thisAmount;
    }

    @Override
    public int volumeCreditBasedOnAudience(int audience) {
        return super.volumeCreditBasedOnAudience(audience) + (int) Math.floor(audience / 5);
    }
}
