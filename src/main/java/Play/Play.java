package Play;

public abstract class Play {

    public String name;
    public String type;

    protected Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static Play create(String name, String type) {
        switch (type) {
            case "tragedy":
                return new TragedyPlay(name, type);
            case "comedy":
                return new ComedyPlay(name, type);
        }
        return new BadPlay(name, type);
    }

    public abstract int getAmount(int audience);

    protected int getAmount(int audience, int baseAmount, int audienceThreshold,
            int fixedSurchargeForAdditionalPerson, int pricePerAdditionalPerson, int pricePerPerson) {
        int thisAmount;
        thisAmount = baseAmount;
        if (audience > audienceThreshold) {
            thisAmount += fixedSurchargeForAdditionalPerson
                    + pricePerAdditionalPerson
                    * (audience - audienceThreshold);
        }
        thisAmount += pricePerPerson * audience;
        return thisAmount;
    }

}
