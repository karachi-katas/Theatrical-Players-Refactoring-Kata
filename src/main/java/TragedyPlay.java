public class TragedyPlay extends Play {
    public TragedyPlay(String name, String type) {
        super(name, type);
    }



    @Override
    int totalAmountBasedOnAudience(int audience) {
        int thisAmount = 40000;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }
        return thisAmount;
    }
}

