package note1

// 2.1.3 变量

// 字符串常量
val question = "The Ultimate Question of Life, the Universe, and Everything"

// Int 类型
val answer = 42

// 如果需要，也可以显式地指定变量的类型
val answer1: Int = 42

// Double 类型
val yearsToCompute = 7.5e6

// 没有初始化器，需要显示指定类型
fun sample31() {
  val answer2: Int
  answer2 = 11
}

// 可变变量和不可变量
val value: Int = 0
var variable = "1"
fun sample1() {
//  value = 2
  variable = "100"
}

// val只能进行唯一一次初始化，假若编译器能保证是这样的话，那么可以根据条件的不同来初始化
fun sample32() {
  val message: String
  if (canPerformOperation()) {
    message = "> 0.5"
  } else {
    message = "< 0.5"
  }
  println(message)
}

fun canPerformOperation(): Boolean {
  return Math.random() > 0.5
}

// val自身不可变，但它所指向的对象可以发生变化
fun sample33() {
  val languages = arrayListOf("Java")
  languages.add("Kotlin")
  println(languages)
}

// var关键字允许变量改变自己的值，但它的类型却是改变不了的
fun sample34() {
  var answer = 42
//  answer = "no answer"
}