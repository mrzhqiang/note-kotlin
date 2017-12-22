package note1

/** 3 函数的定义与调用 */
fun main(args: Array<String>) {
  println("3.1 在Kotlin中创建集合")
  val set = hashSetOf(1, 7, 53)
  val list = arrayListOf(1, 7, 53)
  val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
  println(set.javaClass)
  println(list.javaClass)
  println(map.javaClass)
  println("操作集合")
  val strings = listOf("first", "second", "fourteenth")
  println(strings.last())
  val numbers = setOf(1, 14, 2)
  println(numbers.max())
}