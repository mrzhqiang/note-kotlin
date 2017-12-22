/* 默认是文件名+Kt后缀，使用这个注解可以修改为指定的名字 */
@file:JvmName("JoinJava")
package note1.strings

import note2.joinToString

/* 拷贝的顶层函数 */
@JvmOverloads
fun <T> joinToString1(collection: Collection<T>, separator: String = ", ", prefix: String = "[", postfix: String = "]"): String {
  // 这里只是不希望重复写代码，所以调用了上面的函数，但实际上不应该这么做，而是直接修改上面的函数
  return joinToString(collection, separator, prefix, postfix)
}
