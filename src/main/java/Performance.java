public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    public int getThisAmount() {
        int thisAmount;

        switch (play.type) {
            case "tragedy":
                thisAmount = 40000;
                if (audience > 30) {
                    thisAmount += 1000 * (audience - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (audience > 20) {
                    thisAmount += 10000 + 500 * (audience - 20);
                }
                thisAmount += 300 * audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return thisAmount;
    }
}
