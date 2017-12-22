package note3

/** 3.3 给别人的类添加方法：扩展函数和属性 */
fun main(args: Array<String>) {
  // 像调用类的普通成员函数一样去调用这个函数
  println("Kotlin".lastChar())
  // 只要这种类会编译为java类，就可以为这个类添加自己的扩展

  println("3.3.1 导入和扩展函数")
  // 对于一个定义的扩展函数，不会自动在整个项目范围内生效。如果要使用它，需要进行导入
  // import note3.lastChar
  // 这是为了避免偶然性的命名冲突。也允许使用* 来导入
  // 并且可以使用关键字as 来修改导入的类或者函数名称
  // import note3.lastChar as last
  // val c = "mrzhqiang".last()

  // 不同的包有一些重名的函数时，在导入时重命名就很有必要
  // 通常还可以使用全名来指出类或者函数。
  // 对于扩展函数，Kotlin的语法要求你用简短的名称，所以，在导入声明的时候，关键字as 就是解决冲突的唯一方式

  println("3.3.2 从java中调用扩展函数")
  // 扩展函数是静态函数，它把调用对象作为了它的第一个参数。
  // char c = spreadKt.lastChar("Java");

  println("3.3.3 作为扩展函数的工具函数")
  val list = arrayListOf(1, 2, 3)
  println(list.joinToString("   "))
  // 扩展函数无非就是静态函数的一个高效语法糖，也可以使用更具体的类型作为接收者，而不是一个泛型；
  // 假设想要一个join函数，只能由字符串的集合来触发，然后用其他类型的对象列表来调用，就会报错
  println(listOf("one", "two", "eight").join("   "))
  //  listOf(1, 2, 3).join()

  println("3.3.4 不可重写的扩展函数")
  println("首先使用Kotlin中的重写/继承")
  val view: View = Button()
  view.click()
  println("不能重写扩展函数")
  view.showOff()
  // 扩展函数不存在重写，因为在Kotlin中它们被当作静态函数
  // 注意：如果成员函数和扩展函数具有相同的签名，成员函数往往会被优先使用。
  // 牢记：在扩展API类的时候，如果添加一个和扩展函数同名的成员函数，那么对应类定义的消费者将会重新编译代码
  // 这将会改变它的意义并开始指向新的同名的成员函数

  println("3.3.5 扩展属性")
  println("Android".lastChar)
  val sb = StringBuilder("Phone2017")
  sb.lastChar = '8'
  println(sb)
}

// 函数前面的叫接收者类型，this表示接收者对象，是接收者类型的一个实例，它可以被省略
fun String.lastChar(): Char = /*this.*/get(length - 1)

fun <T> Collection<T>.joinToString(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
  val result = StringBuilder(prefix)
  for ((index, element) in this.withIndex()) {
    if (index > 0) result.append(separator)
    result.append(element)
  }

  result.append(postfix)
  return result.toString()
}

fun Collection<String>.join(separator: String = ", ", prefix: String = " ", postfix: String = " ") = joinToString(separator, prefix, postfix)

open class View {
  open fun click() = println("View clicked")
}

class Button : View() {
  override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a button!")

// 声明一个扩展属性
val String.lastChar: Char get() = get(length - 1)

// 声明一个可变的扩展属性
var StringBuilder.lastChar: Char
  get() = get(length - 1)
  set(value: Char) {
    this.setCharAt(length - 1, value)
  }