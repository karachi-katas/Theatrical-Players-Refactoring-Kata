public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name);
        this.amount = 40000;
    }

    public Integer getPlayAmount(Integer audience){
        Integer currentPlayAmount = amount;
        if (audience > 30) {
            currentPlayAmount += 1000 * (audience - 30);
        }
        return currentPlayAmount;
    }
}