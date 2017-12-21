package note1

/* 2.1.4 更简单的字符串格式化：字符串模板 */
fun main(args: Array<String>) {
  val name = if (args.size > 0) args[0] else "Kotlin"
  // $引用局部变量，\$x就是$x，而不会去引用x变量
  // 表达式会进行静态检查，引用了不存在的变量，则无法通过编译
  println("Hello, $name!")
}

fun data(): ArrayList<String> {
  val data = arrayListOf<String>()
  data.add("Java")
  data.add("Kotlin")
  return data
}

fun sample41() {
  val data = data()
  if (data.size > 0) {
    // $还可以引用更复杂的表达式，而不仅限于简单的变量名称，只需要把表达式用花括号括起来
    println("Hello, ${data[0]}!")
  }
}

fun sample42() {
  val data = data()
  // $还可以在双引号中直接嵌套双引号，只要它们处在某个表达式的范围内（也就是花括号内）
  println("Hello, ${if (data.size > 0) data[0] else "someone"}!")
  // 出现了一个问题，好像中文的 ！ 会出现乱码
}

// 据说：编译后的代码创建了一个StringBuilder对象，并把常量部分和变量附加上去