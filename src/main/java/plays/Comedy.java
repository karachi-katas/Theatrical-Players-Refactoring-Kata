package plays;

public class Comedy extends Play {
    public Comedy(String name, String type) {
        super(name, type);
    }

    @Override
    public int calculateAmount(int audience) {
        int amount = 30000;

        if (audience > 20) amount+=10000 + 500 * (audience - 20);
        amount += 300 * audience;
        return amount;
    }
}
