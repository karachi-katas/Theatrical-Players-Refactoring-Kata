import play.Play;

public class Performance {

    public String playID;
    public int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    public int calculatePerformanceAmount(Play play) {
        return play.getAmount(audience);
        /*switch (play.type) {
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
        }*/
    }

}
