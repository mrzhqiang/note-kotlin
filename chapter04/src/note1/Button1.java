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
}
