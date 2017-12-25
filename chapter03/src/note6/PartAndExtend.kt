package note6

/** 3.6 让你的代码更整洁：局部函数和扩展 */
fun main(args: Array<String>) {
  val user = User(1, "", "")
//  saveUser(user)
//  saveUser1(user)
  user.validateBeforeSave()
}

// 带重复代码的函数
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  if (user.name.isEmpty()) {
    throw IllegalArgumentException("Can't save user ${user.id}: empty name")
  }

  if (user.address.isEmpty()) {
    throw IllegalArgumentException("Can't save user ${user.id}: empty address")
  }

  // 保存user 到数据库
}

// 提取局部函数来避免重复
fun saveUser1(user: User) {
  // 局部函数完全可以访问外层函数的参数
  fun validate(/*user: User, */value: String, fieldName: String) {
    if (value.isEmpty()) {
      throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }
  }
  validate(/*user, */user.name, "Name")
  validate(/*user, */user.address, "Address")
}

// 提取逻辑到扩展函数
fun User.validateBeforeSave() {
  fun validate(value: String, fieldName: String) {
    if (value.isEmpty()) {
      throw IllegalArgumentException("Can't save user $id: empty $fieldName")
    }
  }
  validate(name, "Name")
  validate(address, "Address")
}

/** 3.7 小结 */

// Kotlin 没有重新定义自己的集合类，而是借助java集合类，扩展了更丰富的API

// Kotlin 可以给函数参数定义默认值，这样大大降低重载的必要性，而命名参数让函数调用更易读

// Kotlin 的代码结构更灵活：函数和属性都可以直接在文件中声明，而不仅仅是在类中作为成员

// Kotlin 可以用扩展函数和属性来扩展任何类的API，包括在外部库中定义的类，而不需要修改源码，以及没有运行时开销。

// 中缀调用infix 提供处理单个参数的类似运算符调用的简明语法

// Kotlin 为普通字符串和正则表达式提供大量字符串处理函数

// 三重引号的字符串提供简洁方式，解决原本java中需要进行转义和字符串连接的问题

// 局部函数帮助保持代码整洁的同时避免代码重复