package note4

import java.util.*

/** 2.4 迭代事物：while 循环和 for 循环 */

/* 2.4.1 while 循环 */
fun sample() {
  var n = 0
  while (n < 100) {
    println("n = ${n++}")
  }

  do {
    println("n = ${--n}")
  } while (n > 0)
}

/* 2.4.2 迭代数字：区间和数列 */
fun fizzBuzz(i: Int) = when {
  i % 15 == 0 -> "FizzBuzz "
  i % 5 == 0 -> "Buzz "
  i % 3 == 0 -> "Fizz "
  else -> "$i "
}

// 1..100是指，从1到100，也包括100； 0 until size是指，从0到size-1，不包括size

// 规则变更：从100开始倒数，并且只计算偶数
// for(i in 100 downTo 1 step 2) {...}

/* 2.4.3 迭代map */
fun test1() {
  val binaryReps = TreeMap<Char, String>()

  for (c in 'A'..'F') {
    val binary = Integer.toBinaryString(c.toInt())
    binaryReps[c] = binary
  }

  for ((letter, binary) in binaryReps) {
    println("$letter = $binary  ")
  }
}

// 可以用这样的展开语法在迭代集合的同时跟踪当前项的下标。不需要创建一个单独的变量来存储下标并手动增加它
fun test2() {
  val list = arrayListOf("10", "11", "1001")
  for ((index, element) in list.withIndex()) {
    println("$index: $element  ")
  }
}

/* 2.4.4 使用 in 检查集合和区间的成员 */

// 2.25 使用in检查区间的成员
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

// 2.26 用in检查作为when分支
fun recognize(c: Char) =
    when (c) {
      in '0'..'9' -> "It's a digit!"
      in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
      else -> "I don't know.."
    }
// 区间也不仅限于字符。只要支持实例比较操作的任意类——实现了java.lang.Comparable接口，就能创建这种类型的对象区间
// 比如： "Kotlin" in "Java".."Scala" >>> true
// 字符串是按照字母表的顺序进行比较的
// in 检查也同样适用于集合：
// "Kotlin" in setOf("Java", "Scala") >>> false
// 集合不包含Kotlin