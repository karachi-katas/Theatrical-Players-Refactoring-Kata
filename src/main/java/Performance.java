public class Performance {

    public String playID;
    public int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    int getTragedyAdditionalAmount() {
        if (audience > 30) return 1000 * (audience - 30);
        return 0;
    }

    int getComedyAdditionalAmount() {
        if (audience > 20) return 10000 + 500 * (audience - 20);
        return 0;
    }
}
