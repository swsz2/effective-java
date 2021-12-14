package me.swsz2.effectivejava.chapter2.act3;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-14, 화요일
 */
public class OperatingSystemProperties {

  public static final OperatingSystemProperties INSTANCE = new OperatingSystemProperties();

  /** prevents singleton creation by reflection. */
  private OperatingSystemProperties() {
    if (INSTANCE != null) {
      throw new InstantiationError("already created OperatingSystemProperties");
    }
  }

  public void print() {
    System.out.println("operatingSystemProperties");
  }
}
