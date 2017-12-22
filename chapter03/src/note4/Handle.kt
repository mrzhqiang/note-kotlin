package note4

/** 3.4 处理集合：可变参数、中缀调用和库的支持 */
fun main(args: Array<String>) {
  // 可变参数的关键字vararg，可以用来声明一个函数将有可能有任意数量的参数
  // 一个中缀表示法，当你在调用一些只有一个参数的函数时，使用它会让代码更简练
  // 解构声明，用来把一个单独的组合值展开到多个变量中

  println("3.4.1 扩展java集合的API")
  val strings: List<String> = listOf("first", "second", "fourteenth")
  println(strings.last())
  val numbers: Collection<Int> = setOf(1, 14, 2)
  println(numbers.max())

  println("3.4.2 可变参数：让函数支持任意数量的参数")
  val list = listOf(2, 3, 5, 7, 11)
  // 参数传递给数组，数组通过ArraysUtilJVM.asList调用Arrays.asList转换为ArrayList的实例
  // 通过* 展开运算符，将数组展开为参数
  val argList = listOf("args: ", *args)

  println("3.4 5 键值对的处理:中缀调用和解构声明")
  val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
  // to 就是中缀调用，它没有添加额外的分隔符，函数名称是直接放在目标对象名称和参数之间的
  // 添加. 分隔符与不添加是等价的：
  1.to("one")
  1 to "one"

  // 中缀调用可以与只有一个参数的函数一起使用，无论是普通的函数还是扩展函数。
  // 要允许使用中缀符号调用函数，需要使用infix修饰符来标记它
  infix fun Any.to(other: Any) = Pair(this, other)
  // 上面的to函数，返回一个Pair类型的对象，Pair是Kotlin标准库中的类
  val (number, name) = 1 to "One"
  // 上面的功能称为解构声明

  // TODO 3.5
}