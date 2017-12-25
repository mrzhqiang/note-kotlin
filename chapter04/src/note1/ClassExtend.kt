package note1

import java.io.Serializable

/** 4.1 定义类继承结构 */
fun main(args: Array<String>) {
  /* 4.1.1 Kotlin 中的接口 */
  // 与Java8中的接口相似：可以包含抽象方法的定义以及非抽象方法的实现（Java8中的默认方法类似），不包含任何状态
  // 调用接口实现
  Button().click()
  val button = Button()
  button.showOff()
  button.setFocus(true)
  button.click()

  /* 4.1.2 open final 和abstract 修饰符：默认final */

  /* 4.1.3 可见性修饰符：默认为public */
  //  修饰符：public   internal  protected   private
  //  类：    所有地方  模块中可见 子类中可见   类中可见
  //  顶层：  所有地方  模块中可见 ——          文件中可见

  /* 4.1.4 内部类和嵌套类：默认是嵌套类 */

  /* 4.1.5 密封类：定义受限的类继承结构 */

}

// 声明一个简单的接口
interface Clickable {
  fun click()
  // 在接口中定义一个带方法体的方法
  fun showOff() = println("I'm clickable!")
}

// 实现一个简单接口
class Button : Clickable, Focusable {
  // 两个接口有相同的方法，则必须提供一个显式实现
  override fun showOff() {
    // 尖括号加上super，就可以调用父类方法
    super<Clickable>.showOff()
    super<Focusable>.showOff()
  }

  override fun click() = println("I was clicked")
}

// 定义另一个实现了同样方法的接口
interface Focusable {
  fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
  fun showOff() = println("I'm focusable!")
}

// 声明一个带open方法的open类
open class RichButton : Clickable {
  fun disable() {
    println("默认的我，不可以被子类重写，我又不是接口方法，对吧")
  }

  open fun animate() {
    println("open的我，可以被子类重写")
  }

  override fun click() {
    println("重写了一个open函数，那么我还是open的")
  }
}

open class RealButton : Clickable {
  final override fun click() {
    println("显式地声明final，那么我就不能再被重写了哦")
  }
}

// 声明一个抽象类
abstract class Animated {
  abstract fun animate()
  open fun stopAnimating() {
    println("我是开放的停止动画方法")
  }

  fun animateTwice() {
    println("我是默认final的双倍动画方法")
  }
}

// 违反可见性规则，编译时发生错误
internal open class TalkativeButton : Focusable {
  private fun yell() = println("Hey!")
  protected fun whisper() = println("Let's talk!")
}

/*
fun TalkativeButton.giveSpeech() {
  yell()
  whisper()
}
*/

// 扩展可序列化接口
interface State : Serializable

// 声明包含可序列化状态的视图
interface View {
  fun getCurrentState(): State
  fun restoreState(state: State) {}
}

// 在Kotlin中使用嵌套类来实现View
class Button2 : View {
  override fun getCurrentState(): State = ButtonState()

  override fun restoreState(state: State) {
    /**/
  }

  class ButtonState : State {/**/ }
}

// 在Kotlin中引用外部类实例的语法: this@ + 外部类名字
class Outer {
  inner class Inner {
    fun getOuterReference(): Outer = this@Outer
  }
}

// 作为密封类的表达式
sealed class Expr {
  class Num(val value: Int) : Expr()
  class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
      is Expr.Num -> e.value
      is Expr.Sum -> eval(e.right) + eval(e.left)
    }