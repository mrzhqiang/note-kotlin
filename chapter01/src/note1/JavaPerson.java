package note1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaPerson {

  private final String name;
  private int age = 0;

  public JavaPerson(String name) {
    this.name = name;
  }

  public JavaPerson(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override public String toString() {
    return this.getClass().getSimpleName() + "(" + "name=" + name + ", age=" + age + ")";
  }

  public static void main(String[] args) {
    List<JavaPerson> list = new ArrayList<>();
    list.add(new JavaPerson("Alice"));
    list.add(new JavaPerson("Bob", 29));
    System.out.println(maxBy(list));
  }

  private static JavaPerson maxBy(Collection<JavaPerson> collection) {
    JavaPerson temp = null;
    for (JavaPerson javaPerson : collection) {
      if (temp == null || javaPerson.age > temp.age) {
        temp = javaPerson;
      }
    }
    return temp;
  }
}
