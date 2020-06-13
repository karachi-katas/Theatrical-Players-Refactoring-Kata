import java.util.HashMap;
import java.util.function.Supplier;

public class Audience {

  public int count;
  public HashMap<String, Supplier<Integer>> extraAmount;

  public Audience(int count) {
    this.count = count;
    extraAmount = new HashMap<>();
    extraAmount.put("tragedy",()-> (count > 30) ? 1000 * (count - 30) : 0);
    extraAmount.put("comedy",()-> ((count > 20) ?  10000 + 500 * (count - 20)  : 0) + 300 * count);
  }

  public int getExtraAmount(String playType){
    return extraAmount.getOrDefault(playType,() -> 0).get();
  }
}
