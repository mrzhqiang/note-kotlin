package note2;

/* JavaBean */
public class Person {
  private final String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static void main(String[] args) {
    PersonKt personKt = new PersonKt("aaa", false);
    System.out.println(personKt.getName());
    System.out.println(personKt.isMarried());
  }
}
