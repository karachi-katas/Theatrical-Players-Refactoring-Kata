package play;

public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name, "tragedy");
    }

    @Override
    public int getAmount(int audience) {
        int thisAmount = 40000;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }
        return thisAmount;
    }
}
