package plays;

public class Tragedy extends Play {
    public Tragedy(String name, String type) {
        super(name, type);
    }

    @Override
    public int calculateAmount(int audience) {
        int amount = 40000;
        if (audience > 30) amount+= 1000 * (audience - 30);

        return amount;
    }

    @Override
    public int calculateVolumeCredit(int audience) {
        return Math.max(audience - 30, 0);
    }
}
