public class Audience {

  public int count;

  public Audience(int count) {
    this.count = count;
  }

  public int getExtraAmount(String playType){
    if("tragedy".equals(playType)){
      if (count > 30) {
        return  1000 * (count - 30);
      }
    }
    else if("comedy".equals(playType)){
      if (count > 20) {
        return 10000 + 500 * (count - 20);
      }
    }
    return 0;
  }
}
