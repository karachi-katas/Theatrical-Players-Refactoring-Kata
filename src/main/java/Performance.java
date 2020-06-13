import AmountStrategies.AmountCalculator;
import AmountStrategies.ComedyPlayCalculator;
import AmountStrategies.TragedyPlayCalculator;
import AmountStrategies.UnknownPlayCalculator;

public class Performance {

    private String playID;
    private int audience;
    private AmountCalculator amountCalculator;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;

        switch (PlaysRepository.getInstance().findPlayById(playID).type) {
            case "comedy":
                amountCalculator = new ComedyPlayCalculator();
                break;

            case "tragedy":
                amountCalculator = new TragedyPlayCalculator();
                break;

            default:
                amountCalculator = new UnknownPlayCalculator();
                break;
        }
    }

    public int getAmount() {
        return amountCalculator.calculate(this.audience);
    }

    public int getAudience() {
        return audience;
    }

    public String getPlayID() {
        return playID;
    }
}
