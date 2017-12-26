package note1;

import org.jetbrains.annotations.NotNull;

public class Button1 implements View {
  @NotNull @Override public State getCurrentState() {
    return new ButtonState();
  }

  @Override public void restoreState(@NotNull State state) {

  }

  public class ButtonState implements State {
  }

  // 测试下抽象字段
  public static abstract class AbstractField {
    // java中字段无法用abstract修饰
    public String name;
  }

  // 测试下接口字段
  public interface IField {
    // 只能是静态的常量吗？
    String name = "";
  }

  public static void main(String[] args) {
    // 果然不能修改
    //IField.name = "111";
  }
}
