package plays;

public class Invalid extends Play {

    public Invalid(String name, String type) {
        super(name, type);
    }

    @Override
    public int calculateAmount(int audience) {
        throw new Error("unknown type: ${type}");
    }
}
