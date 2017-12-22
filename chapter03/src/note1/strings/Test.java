package note1.strings;

import java.util.ArrayList;
import java.util.List;

public class Test {

  private static final List<String> dataList = new ArrayList<>();

  static {
    dataList.add("1");
    dataList.add("22");
    dataList.add("333");
    dataList.add("4444");
    dataList.add("55555");
  }

  public static void main(String[] args) {
    System.out.println(JoinJava.joinToString1(dataList));
    System.out.println(JoinJava.joinToString1(dataList, "!!"));
    System.out.println(JoinJava.joinToString1(dataList, ", ", "pppp"));
    System.out.println(JoinJava.joinToString1(dataList, "||||", "aaaa", "zzzz"));
  }
}
