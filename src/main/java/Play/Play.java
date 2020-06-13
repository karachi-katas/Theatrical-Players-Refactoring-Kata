package Play;

public abstract class Play {

    protected int baseAmount = 30000;
    protected int audienceThreshold = 20;
    protected int fixedSurchargeForAdditionalPerson = 10000;
    protected int pricePerPerson = 300;
    protected int pricePerAdditionalPerson = 500;


    public String name;
    public String type;

    protected Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static Play create(String name, String type) {
        if (type == "tragedy") {
            return new TragedyPlay(name, type);
        }
        if (type == "comedy"){
            return new ComedyPlay(name, type);
        }
        return new BadPlay(name, type);
    }

    public int getAmount(int audience) {
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
