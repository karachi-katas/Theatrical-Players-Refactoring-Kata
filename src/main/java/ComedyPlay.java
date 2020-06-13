public class ComedyPlay extends Play {

    protected ComedyPlay(String name, String type) {

        super(name, type);

        super.baseAmount = 30000;
        super.audienceThreshold = 20;
        super.fixedSurchargeForAdditionalPerson = 10000;
        super.pricePerPerson = 300;
        super.pricePerAdditionalPerson = 500;

    }
}
