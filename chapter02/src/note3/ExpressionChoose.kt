package note3

/** 2.3 表示和处理选择：枚举和 when */

/* 2.3.1 声明枚举类 */
enum class Color(val r: Int, val g: Int, val b: Int) {
  RED(255, 0, 0), ORANGE(255, 165, 0),
  YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
  INDIGO(75, 0, 130), VIOLET(238, 130, 238);

  fun rgb() = (r * 256 + g) * 256 + b
}

/* 2.3.2 使用 when 处理枚举类 */
fun getMnemonic(color: Color) =
    when (color) {
      Color.RED -> "Richard"
      Color.ORANGE -> "Of"
      Color.YELLOW -> "York"
      Color.GREEN -> "Gave"
      Color.BLUE -> "Battle"
      Color.INDIGO -> "In"
      Color.VIOLET -> "Vain"
    }

// 匹配同一类的多个值
fun getWarmth(color: Color) = when (color) {
  Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
  Color.GREEN -> "neutral"
  Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
      setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
      setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
      setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
      else -> throw Exception("Dirty color")
    }

/* 2.3.4 使用不带参数的 when */
fun mixOptimized(c1: Color, c2: Color) = when {
  (c1 == Color.RED && c2 == Color.YELLOW) ||
      (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE

  (c1 == Color.YELLOW && c2 == Color.BLUE) ||
      (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN

  (c1 == Color.BLUE && c2 == Color.VIOLET) ||
      (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.VIOLET

  else -> throw Exception("Dirty color")
}

/* 2.3.5 智能转换：合并类型检查和转换 */
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
  if (e is Num) {
    // 显式地转换成类型，是多余的，在判断之后，就已经做了智能转换
    val n = e as Num
    return n.value
  }
  if (e is Sum) {
    return eval(e.right) + eval(e.left)
  }
  throw IllegalArgumentException("Unknown expression")
}

/* 2.3.6 重构：用 when 代替 if */

// 首先，由于if有返回值，并且kotlin中没有三元运算符，因此可以这样改：
fun eval1(e: Expr): Int =
    // 如果if分支中只有一个表达式，花括号是可以省略的。
    if (e is Num) {
      // 如果if分支是一个代码块，代码块中的最后一个表达式会被作为结果返回
      e.value
    } else if (e is Sum) {
      eval1(e.right) + eval(e.left)
    } else {
      throw IllegalArgumentException("Unknown expression")
    }

// 然后，使用 when 代替 if 层叠
fun eval2(e: Expr): Int =
    when (e) {
      is Num -> e.value
      is Sum -> eval2(e.right) + eval2(e.left)
      else -> throw IllegalArgumentException("Unknown expression")
    }

/* 2.3.7 代码块作为 if 和 when 的分支 */
fun eval3(e: Expr): Int =
    when (e) {
      is Num -> {
        // $可以引用变量，加上花括号就可以引用表达式，也就是使用变量去get属性
        println("num: ${e.value}")
        // 最后的语句，作为值返回
        e.value
      }
      is Sum -> {
        val left = eval3(e.left)
        val right = eval3(e.right)
        println("sum: $left + $right")
        left + right
      }
      else -> throw IllegalArgumentException("Unknown expression")
    }