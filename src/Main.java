import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Object> list = new ArrayList<>(List.of(1,2));
    System.out.println("list = " + list.get(0));
    System.out.println("listsize =" + list.size());
    list.remove(0);
    System.out.println("list = " + list.get(0));
    System.out.println("listsize =" + list.size());

  }
}