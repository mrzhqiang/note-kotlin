package note1

// 2.1.2 函数

// 可以使用交互式shell： Tools >>> Kotlin >>> Kotlin REPL
// 然后在run面板里面，直接运行kotlin的函数

// 代码块体函数
/*
fun max(a: Int, b: Int): Int {
  return if (a > b) a else b
}
*/

// 表达式体函数
/*fun max(a: Int, b: Int): Int = if (a > b) a else b*/

// 不声明返回类型的表达式体函数
fun max(a: Int, b: Int) = if (a > b) a else b
