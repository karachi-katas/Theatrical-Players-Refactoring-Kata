import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }
    public int generateInvoice(Performance perf){
        Play play = perf.play;
        int thisAmount = play.getBaseAmount();
        int volumeCredits = 0;

        switch (play.type) {
            case "tragedy":
                if (perf.audience > 30) {
                    thisAmount += 1000 * (perf.audience - 30);
                }
                break;
            case "comedy":
                if (perf.audience > 20) {
                    thisAmount += 10000 + 500 * (perf.audience - 20);
                }
                thisAmount += 300 * perf.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }



        // add volume credits


        return thisAmount ;

    }

    public int getVolumeCredits(Performance perf){
        int volumeCredits = 0;
        volumeCredits += Math.max(perf.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(perf.play.type)) volumeCredits += Math.floor(perf.audience / 5);
        return volumeCredits;
    }
}
