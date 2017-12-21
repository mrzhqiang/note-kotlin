package note5

import java.io.BufferedReader

/** 2.5 Kotlin 中的异常 */

// Kotlin 中异常处理语句的基本形式和Java类似，抛出异常的方式也不例外：
fun test1() {
  val percentage: Int = -1
  if (percentage !in 0..100) {
    throw IllegalArgumentException("A percentage vale must be between 0 and 100: $percentage  ")
  }
}

// throw 结构是一个表达式，能作为另一个表达式的一部分使用
fun test2() {
  val number: Int = 10
  val percentage =
      if (number in 0..100) {
        number
      } else {
        throw IllegalArgumentException("number = $number")
      }
  println(percentage)
}

/* 2.5.1 try 和 catch 和 finally */
fun readNumber(reader: BufferedReader): Int? {
  try {
    val line = reader.readLine()
    return Integer.parseInt(line)
  } catch (e: NumberFormatException) {
    return null
  } finally {
    reader.close()
  }
}

/* 2.5.2 try 作为表达式 */
// 把 try 当作表达式使用
fun readNumber1(reader: BufferedReader) {
  val number = try {
    Integer.parseInt(reader.readLine())
  } catch (e: NumberFormatException) {
    return
  }
  println(number)
}

// 在 catch 中返回值
fun readNumber2(reader: BufferedReader) {
  val number = try {
    Integer.parseInt(reader.readLine())
  } catch (e: NumberFormatException) {
    null
  }
  println(number)
}

/** 2.6 小结 */
// fun 关键字用来声明函数。val 关键字和var 关键字分别用来声明只读变量和可变变量。

// 字符串模板帮助你避免烦琐的字符串连接。在变量名称前加上$ 前缀或者用${ } 包围一个表达式，来把值注入到字符串中。

// 值对象类在Kotlin 中以简洁的方式表示。

// 熟悉的if 现在是带返回值的表达式。

// when 表达式类似于Java 中的switch 但功能要更强大。

// 在检查过变量具有某种类型之后不必显式地转换它的类型：编译器使用智能转换自动帮你完成。

// for/while和do-while 循环于Java 类似，但for 循环现在更加方便，特别是当你需要迭代map 的时候，
// 又或是迭代集合需要下标的时候。

// 简洁的语法1..5 会创建一个区间。区间和数列允许Kotlin 在for 循环中使用统一的语法和同一套抽象机制，
// 并且还可以使用in 运算符和!in 运算符来检查值是否属于某个区间。

// Kotlin 中的异常处理和Java 非常相似，除了Kotlin 不要求你声明函数可以抛出的异常。