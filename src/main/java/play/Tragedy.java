package play;

public class Tragedy extends Play {

    public Tragedy(String name, String type) {
        super(name, type);
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
