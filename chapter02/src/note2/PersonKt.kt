package note2

/* Kotlin */
class PersonKt(val name: String, var isMarried: Boolean)

fun main(args: Array<String>) {
  // 调用构造方法不需要关键字 new
  val person = PersonKt("Bob", true)
  // 可以直接访问属性，但调用的是 getter
  println(person.name)
  println(person.isMarried)
}