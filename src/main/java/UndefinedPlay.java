public class UndefinedPlay extends Play {

    public UndefinedPlay(String name) {
        super(name);
    }

    public Integer getAmount(){
        throw new Error("unknown type: ${play.type}");
    }
}
