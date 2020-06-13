public class TragedyPlay extends Play {

    protected TragedyPlay(String name, String type) {

        super(name, type);

        super.baseAmount = 40000;
        super.fixedSurchargeForAdditionalPerson = 10000;
        super.pricePerAdditionalPerson = 500;
        super.pricePerPerson = 300;
        super.audienceThreshold = 20;

    }
}
