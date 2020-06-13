package plays;

public class Invalid extends Play {

    public Invalid(String name) {
        super(name);
    }

    @Override
    public int calculateAmount(int audience) {
        throw new Error("unknown type: ${type}");
    }

    @Override
    public int calculateVolumeCredit(int audience) {
        return 0;
    }
}
