import AmountStrategies.InvoiceCalculator;
import AmountStrategies.ComedyPlayCalculator;
import AmountStrategies.TragedyPlayCalculator;
import AmountStrategies.UnknownPlayCalculator;

public class Performance {

    private String playID;
    private int audience;
    private InvoiceCalculator invoiceCalculator;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;

        switch (PlaysRepository.getInstance().findPlayById(playID).type) {
            case "comedy":
                invoiceCalculator = new ComedyPlayCalculator();
                break;

            case "tragedy":
                invoiceCalculator = new TragedyPlayCalculator();
                break;

            default:
                invoiceCalculator = new UnknownPlayCalculator();
                break;
        }
    }

    public int getAmount() {
        return invoiceCalculator.calculateAmount(this.audience);
    }

    public int getCredits() {
        return invoiceCalculator.calculateCredits(this.audience);
    }

    public int getAudience() {
        return audience;
    }

    public String getPlayID() {
        return playID;
    }
}
