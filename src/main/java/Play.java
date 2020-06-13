public class Play {

    public static final int TRAGEDY_BASE_AMOUNT = 40000;
    public static final int TRAGEDY_AUDIENCE_THRESHOLD = 30;
    public static final int TRAGEDY_PRICE_PER_ADDITIONAL_PERSON = 1000;
    public static final int COMEDY_BASE_AMOUNT = 30000;
    public static final int COMEDY_AUDIENCE_THRESHOLD = 20;
    public static final int COMEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE = 10000;
    public static final int COMEDY_PRICE_PER_ADDITIONAL_PERSON = 500;
    public static final int COMEDY_PRICE_PER_PERSON = 300;
    public static final int TRAGEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE = 0;
    public static final int TRAGEDY_PRICE_PER_PERSON = 0;

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    int getAmount(Performance perf) {
        int thisAmount = 0;

        switch (type) {
            case "tragedy":
                thisAmount = getTragedyAmount(perf.audience);
                break;
            case "comedy":
                thisAmount = getComedyAmount(perf.audience);
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return thisAmount;
    }

    private int getComedyAmount(int audience) {
        return getAmount(audience, COMEDY_BASE_AMOUNT, COMEDY_AUDIENCE_THRESHOLD, COMEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE, COMEDY_PRICE_PER_ADDITIONAL_PERSON, COMEDY_PRICE_PER_PERSON);
    }

    private int getAmount(int audience, int comedyBaseAmount, int comedyAudienceThreshold, int comedyFixedSurchargeForAdditionalAudience, int comedyPricePerAdditionalPerson, int comedyPricePerPerson) {
        int thisAmount;
        thisAmount = comedyBaseAmount;
        if (audience > comedyAudienceThreshold) {
            thisAmount += comedyFixedSurchargeForAdditionalAudience
                    + comedyPricePerAdditionalPerson
                    * (audience - comedyAudienceThreshold);
        }
        thisAmount += comedyPricePerPerson * audience;
        return thisAmount;
    }

    private int getTragedyAmount(int audience) {
        return getAmount(audience, TRAGEDY_BASE_AMOUNT, TRAGEDY_AUDIENCE_THRESHOLD, TRAGEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE, TRAGEDY_PRICE_PER_ADDITIONAL_PERSON, TRAGEDY_PRICE_PER_PERSON);
    }

}
