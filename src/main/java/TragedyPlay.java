public class TragedyPlay extends Play {

    protected TragedyPlay(String name, String type) {

        super(name, type);

        super.baseAmount = 40000;
        super.fixedSurchargeForAdditionalPerson = 0;
        super.pricePerAdditionalPerson = 1000;
        super.pricePerPerson = 0;
        super.audienceThreshold = 30;

    }
}
