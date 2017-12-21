package note2

import java.util.*

/* 2.2.2 自定义访问器 */
class Rectangle(val height: Int, val width: Int) {
  val isSquare: Boolean
  get() = height == width
}

/* 2.2.3 Kotlin 源码布局：目录和包 */
fun createRandomRectangle(): Rectangle {
  val random = Random()
  return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
  println(createRandomRectangle().isSquare)
}