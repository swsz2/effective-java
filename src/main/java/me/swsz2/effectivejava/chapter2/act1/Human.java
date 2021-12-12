package me.swsz2.effectivejava.chapter2.act1;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-12, 일요일
 */
public abstract class Human {

  public enum Sex {
    MALE,
    FEMALE
  }

  public abstract void eat();

  /**
   * @param sex sex
   * @return new Man or Women Instance
   */
  public static Human create(final Human.Sex sex) {
    switch (sex) {
      case MALE:
        return new Man();
      case FEMALE:
        return new Women();
    }
    throw new IllegalArgumentException("undefined sex :" + sex);
  }

  /** @return new Man Instance */
  public static Human newWomenInstance() {
    return new Women();
  }

  /** @return new Man Instance */
  public static Human newManInstance() {
    return new Man();
  }
}
