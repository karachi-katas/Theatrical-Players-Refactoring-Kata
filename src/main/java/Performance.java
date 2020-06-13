import AmountStrategies.*;

public class Performance {

    private String playID;
    private int audience;
    private InvoiceCalculator invoiceCalculator;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;

        String playType = PlaysRepository.getInstance().findPlayById(playID).type;
        invoiceCalculator = AmountStrategyFactory.getAmountCalculatorStrategy(playType);
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
