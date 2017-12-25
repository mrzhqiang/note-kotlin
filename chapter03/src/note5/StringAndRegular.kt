package note5

/** 3.5 字符串和正则表达式的处理 */
fun main(args: Array<String>) {
  /* 3.5.1 分割字符串 */
  // split方法，在java中，接受正则表达式. 符号，kotlin则将这个函数隐藏，并替换为一些不同参数的重载的扩展函数
  // 承载正则表达式的值，需要一个Regex类型
  val data = "12.345-6.A"
  // \\.|- >>> [.-]
  println(data.split("[.-]".toRegex()))
  // 也可以支持任意数量的纯文本字符串分隔符，下面这个方法不是正则表达式
  println(data.split(".", "-"))

  /* 3.5.2 正则表达式和三重引号的字符串 */
  // 使用String的扩展函数来解析文件路径
  val path = "/Users/yole/kotlin-book/chapter.adoc"
  parsePath(path)
  // 使用正则表达式解析文件路径
  parsePath1(path)

  /* 3.5.3 多行三重引号的字符串 */
  val kotlinLogo = """|  //
                     .| //
                     .|/ \"""
  println(kotlinLogo.trimMargin("."))
}

// 没有使用任何正则表达式，这看起来有点奇怪
fun parsePath(path: String) {
  val directory = path.substringBeforeLast("/")
  val fullName = path.substringAfterLast("/")

  val fileName = fullName.substringBeforeLast(".")
  val extension = fullName.substringAfterLast(".")

  println("Dir: $directory, name: $fileName, ext: $extension")
}

// 试试正则表达式
fun parsePath1(path: String) {
  val regex = """(.+)/(.+)\.(.+)""".toRegex()
  val matchResult = regex.matchEntire(path)
  if (matchResult != null) {
    val (directory, filename, extension) = matchResult.destructured
    println("Dir: $directory, name: $filename, ext: $extension")
  }
}