public class Comedy extends Play {

    public Comedy(String name) {
        super(name);
        this.amount = 30000;
    }

    public Integer getPlayAmount(Integer audience){
        Integer currentPlayAmount = amount;
        if (audience > 20) {
            currentPlayAmount += 10000 + 500 * (audience - 20);
        }
        currentPlayAmount += 300 * audience;
        return currentPlayAmount;
    }

    public Integer getVolumeCredits(Integer audience){
        int amountCredits = super.getVolumeCredits(audience);
        amountCredits += Math.floor(audience / 5);
        return amountCredits;
    }
}
