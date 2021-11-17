package me.swsz2.effectivejava.chapter1;

import lombok.ToString;

/** Created by sungwonkim on 2021-11-17 */
public class Act1 {
  /*
   * # 생성자 대신 정적 팩터리 메서드를 고려하라
   * 클라이언트가 클래스의 인스턴스를 얻는 전통적인 수단은 public 생성자이다.
   * 하지만 모든 프로그래머가 꼭 알아둬야 할 기법이 하나 더 있다.
   * 클래스는 생성자와 별도로 정적 팩터리 메서드를 제공할 수 있다.
   * 그 클래스의 인스턴스를 반환하는 단순한 정적 메서드 말이다.
   */
  public static void main(final String... args) {

    // 장점
    //// 1. 이름을 가질 수 있다.
    Student.createFemaleStudent("PARK HYE LIN", 25);
    Student.createMaleStudent("KIM SUNG WON", 28);

    //// 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    Student.createEmptyStudentBySex(Human.Sex.FEMALE);
    Student.createEmptyStudentBySex(Human.Sex.MALE);

    //// 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    Humans.asHuman(Human.Sex.FEMALE);
    Humans.asHuman(Human.Sex.MALE);

    //// 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    Humans.asHuman(18, Human.Sex.FEMALE);
    Humans.asHuman(28, Human.Sex.MALE);

    //// 5. 정적 팩토리 메소드를 작성하는 시점에는 반환할 객체의 클래스가 없어도 된다.

    // 단점
    //// 1. 상속을 할 땐 public or protected 생성자가 필요하기에 정적 팩토리 메서드만 사용하면 하위 클래스를 만들 수 없다.
    //// 2. 정적 팩토리 메소드는 프로그래머가 찾기 힘들다.
  }

  public static class Humans {
    public static Human asHuman(final Human.Sex sex) {
      return new Student(sex);
    }

    public static Human asHuman(final int age, final Human.Sex sex) {
      return age > 20 ? new Adult(age, sex) : new Student(age, sex);
    }
  }

  @ToString
  public abstract static class Human {
    protected String name;
    protected Student.Sex sex;
    protected int age;

    public Human(final String name, final int age, final Sex sex) {
      this.name = name;
      this.sex = sex;
      this.age = age;
    }

    public Human(final int age, final Sex sex) {
      this.sex = sex;
      this.age = age;
    }

    public Human(final Sex sex) {
      this.sex = sex;
    }

    enum Sex {
      MALE,
      FEMALE
    }
  }

  @ToString
  static class Adult extends Human {
    public Adult(final int age, final Sex sex) {
      super(age, sex);
    }
  }

  @ToString
  static class Student extends Human {

    private static Student EMPTY_FEMALE = new Student(Sex.FEMALE);
    private static Student EMPTY_MALE = new Student(Sex.FEMALE);

    public Student(final Sex sex) {
      super(sex);
    }

    public Student(final int age, final Sex sex) {
      super(age, sex);
    }

    public Student(final String name, final int age, final Sex sex) {
      super(name, age, sex);
    }

    public static Student createFemaleStudent(final String name, final int age) {
      return new Student(name, age, Sex.FEMALE);
    }

    public static Student createMaleStudent(final String name, final int age) {
      return new Student(name, age, Sex.MALE);
    }

    public static Student createEmptyStudentBySex(final Sex sex) {
      return sex == Sex.FEMALE ? EMPTY_FEMALE : EMPTY_MALE;
    }
  }
}
