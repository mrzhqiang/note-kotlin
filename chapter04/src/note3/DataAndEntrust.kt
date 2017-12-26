package note3

/** 4.3 数据类和类委托 */
fun main(args: Array<String>) {
  /* 4.3.1 通用对象方法 */
  // 试着输出一个对象
  println(Client("Kotlin", 10))
  // 对象相等性：equals()
  val client1 = Client("Alice", 100)
  val client2 = Client("Alice", 100)
  // Kotlin中，==检查对象是否相等，而不是比较值，这里会编译成调用equals方法
  println(client1 == client2)
  // Hash 容器：hashCode()
  val processed = hashSetOf(Client("Android", 1))
  println(processed.contains(Client("Android", 1)))
  // 上面要做的事情太多了，而Kotlin可以自动这些事情

  /* 4.3.2 数据类：自动生成通用方法的实现 */
  val newClient1 = NewClient("Alice", 100)
  val newClient2 = NewClient("Alice", 100)
  println(newClient1 == newClient2)
  val processed1 = hashSetOf(newClient1)
  println(processed1.contains(newClient2))
  // 数据类不仅仅自动生成常见的toString equals hashCode方法，并且还有一个copy方法
  println(newClient1.copy(name = "AN", postalCode = 1))
  // 有了Kotlin，那还学什么Effective Java，还用什么Auto-Value

  /* 4.3.3 类委托：使用 by 关键字 */
  val cset = CountingSet<Int>()
  cset.addAll(listOf(1, 2, 3, 1))
  println("${cset.objectAdded} objects were added, ${cset.size} remain")
}

// 声明一个Client类
class Client(val name: String, val postalCode: Int) {
  // 覆盖字符串方法
  override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"

  // Any是Object的模拟，它在Kotlin中是所有类的父类
  override fun equals(other: Any?): Boolean {
    if (other == null || other !is Client) {
      return false
    }
    return name == other.name && postalCode == other.postalCode
  }

  override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

// 数据类，只需要一个data修饰，剩下的编译期间会自动完成
data class NewClient(val name: String, val postalCode: Int)

// 装饰器模式
class DelegatingCollection<T> : Collection<T> {
  override val size: Int
    get() = innerList.size

  override fun contains(element: T): Boolean = innerList.contains(element)

  override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

  override fun isEmpty(): Boolean = innerList.isEmpty()

  override fun iterator(): Iterator<T> = innerList.iterator()

  private val innerList = arrayListOf<T>()

}

// 将接口的实现委托给另一个对象（自然是同一个接口）
class Delegating<T>(innerList: Collection<T> = arrayListOf()) : Collection<T> by innerList

// 使用类委托
class CountingSet<T>(val innerSet: MutableCollection<T> = hashSetOf()) : MutableCollection<T> by innerSet {
  var objectAdded = 0
  override fun add(element: T): Boolean {
    objectAdded++
    return innerSet.add(element)
  }

  override fun addAll(elements: Collection<T>): Boolean {
    objectAdded += elements.size
    return innerSet.addAll(elements)
  }
}