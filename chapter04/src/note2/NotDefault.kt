package note2

/** 4.2 声明一个带非默认构造方法和属性的类 */
fun main(args: Array<String>) {
  /* 4.2.1 初始化类：主构造方法和初始化语句块 */
  // 创建一个类的实例，只需要直接调用构造方法，不需要new关键字
  val account = Account(User("enjoy your life"))

  /* 4.2.2 构造方法：用不同的方式来初始化父类 */

  /* 4.2.3 实现在接口中声明的属性 */

  /* 4.2.4 通过getter 或setter 访问支持字段 */
  val sun = Sun("summer")
  sun.address = "4096"

  /* 4.2.5 修改访问器的可见性 */
  val counter = LengthCounter()
  counter.addWord("11111")
  // 因为是私有的set，因此无法使用赋值语句在外面赋值
//  counter.counter = 1
  println(counter.counter)
}

// 声明一个简单类
class User(val nickname: String)

// 完成同样事情，但代码最为明确
class User1 constructor(nickname: String) {
  val nickname: String

  init {
    this.nickname = nickname
  }
}

// 如果没有注解或可见性修饰符，可以去掉constructor
// 然后初始化语句块中也不需要初始化代码，因为nickname在声明时即可赋予参数值
class User2(nickname: String) {
  val name = nickname
}

// 可以像函数参数一样为构造方法参数声明一个默认值
class Account(val user: User, val name: String = "")

// 声明一个可扩展的颜色类
open class Color(val r: Int, val g: Int, val b: Int)

// 扩展颜色类，主构造方法需要初始化父类
class Red(r: Int, g: Int, b: Int) : Color(r, g, b) {
  // todo something
}

// 如果不给一个类声明任何的构造方法，将会生成一个不做任何事情的默认构造方法：
open class ListView

// 如果继承一个最简单的类，比如ListView，则必须显式地调用父类的构造方法，即使它没有任何参数
class ArrayListView : ListView()

// 注意：与接口的不同在于，接口没有构造方法，所以实现接口的时候，不需要加括号。

// 如果要确保类不被其他代码实例化，必须把构造方法标记为private

class Secretive private constructor() {}

// 因为Secretive 类只有一个private 的构造方法，这个类外部的代码不能实例化它

// 尽管Kotlin的主构造方法已经覆盖了大部分情况，但是总有一些不如意的地方

class Context

class AttributeSet

open class View {
  constructor(ctx: Context) {
    // some code
  }

  constructor(ctx: Context, attr: AttributeSet) {
    // some code
  }
}

// 扩展这个类
class MyButton : View {
  // 可以使用this关键字调用自身的构造方法，跟java一样
  constructor(ctx: Context) : this(ctx, AttributeSet())

  constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr)
}

interface Smith {
  val nickname: String
}

class Randall(override val nickname: String) : Smith

class Rose(val email: String) : Smith {
  override val nickname: String
    get() = email.substringBefore('@')
}

class Dusk(accountId: Int) : Smith {
  override val nickname = getDuskName(accountId)

  fun getDuskName(id: Int) = id.toString()
}

// 在setter中访问支持字段
class Sun(val name: String){
  var address: String = "unspecified"
  set(value) {
    println(""" Address was changed for $name: "$field" -> "$value".""".trimIndent())
    field = value
  }
}

class LengthCounter {
  var counter: Int = 0
  private set

  fun addWord(word: String) {
    counter += word.length
  }
}