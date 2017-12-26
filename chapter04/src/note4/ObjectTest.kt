package note4

/** 4.4 object 关键字：将声明一个类与创建一个实例结合起来 */
fun main(args: Array<String>) {
  /* 4.4.1 对象声明：创建单例易如反掌 */
  // object声明的对象，可以直接使用名字+ . + 类中的属性或方法名字，来访问它们
  Payroll.allEmployees.add(Person(name="111", id=11))
  Payroll.calculateSalary()
}

data class Person(private val id: Int = 0, val name: String = "Person")

// 声明一个类并且同时创建了一个实例
object Payroll {
  val allEmployees = arrayListOf<Person>()

  fun calculateSalary() {
    for (person in allEmployees) {
      println(person)
    }
  }
}

