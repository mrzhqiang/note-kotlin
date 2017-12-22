package note2

fun main(args: Array<String>) {
  println("3.2 让函数更好调用")
  val list = listOf(1, 2, 3)
  println(list)
  println("joinToString() 的基本实现")
  println(joinToString(list, ";", "(", ")"))
  println("函数是可行的，但是差不多可以丢下了，接下来是：修改，让调用更简洁——避免每次调用的4个传参")
  println("3.2.1 命名参数")
  println(joinToString(list, separator = " ", prefix = " ", postfix = "."))
  println("3.2.2 默认参数值")
  println(joinToString1(list, ", ", "", ""))
  println(joinToString1(list))
  println(joinToString1(list, "; "))
  println("常规的调用语法，必须按照顺序来，可以省略的仅仅是末尾的参数——即不能从中间省略；而命名参数是可以的，甚至任意顺序传参")
  println(joinToString1(list, postfix = ";", prefix="# "))
  println("默认值编码在函数中，如果改变了默认值，而调用者不对其重新赋值的话，将会开始使用新的默认值")
  println(joinToString1(list))
  println("3.2.3 消除静态工具类：顶层函数和属性")
  println("顶层函数就是，在Kotlin文件中，没有被嵌套的函数")
  println("顶层属性就是，在Kotlin文件中，写在最外面的属性")
  println("当使用java调用这些属性时，val修饰的只有getter，而var则拥有getter和setter")
  println("如果要暴露一个常量，比如在java中以public static final的形式声明，那么可以用const来修饰它")
  println("const适用于所有的基本数据类型以及String类")
}

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
  val result = StringBuilder(prefix)
  for ((index, element) in collection.withIndex()) {
    if (index > 0) {
      result.append(separator)
    }
    result.append(element)
  }
  result.append(postfix)
  return result.toString()
}

/* 改进函数 */
/*
关于@JvmOverloads注解：
当使用时，编译器将生成java重载函数，从最后一个参数开始逐步省略，直到剩下没有默认值的参数；
这是由于java没有参数默认值的概念造成的，从java调用这个函数，必须显式地指定所有参数值，要想省略，就必须重载函数
*/
@JvmOverloads
fun <T> joinToString1(collection: Collection<T>, separator: String = ", ", prefix: String = "[", postfix: String = "]"): String {
  // 这里只是不希望重复写代码，所以调用了上面的函数，但实际上不应该这么做，而是直接修改上面的函数
  return joinToString(collection, separator, prefix, postfix)
}

/* 顶层属性 */

// 相当于静态类变量
var opCount = 0

fun performOperation() {
  opCount++
}

fun reportOperationCount() {
  println("Operation performed $opCount times")
}

// 相当于静态类常量
val UNIX_LINE_SEPARATOR = "\n"

// 相当于公开的静态类常量
const val UNIX_LINE_SPEARATOR_CONST = "\r\n"