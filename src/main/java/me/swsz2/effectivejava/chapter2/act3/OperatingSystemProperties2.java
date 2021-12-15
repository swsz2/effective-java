package me.swsz2.effectivejava.chapter2.act3;

import java.io.Serializable;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-14, 화요일
 */
public class OperatingSystemProperties2 implements Serializable {

  private static final OperatingSystemProperties2 INSTANCE = new OperatingSystemProperties2();

  /** prevents singleton creation by reflection. */
  private OperatingSystemProperties2() {
    if (INSTANCE != null) {
      throw new AssertionError("already created OperatingSystemProperties2");
    }
  }

  public static OperatingSystemProperties2 getInstance() {
    return INSTANCE;
  }
  /** prevents singleton creation by deserialization. */
  private Object readResolve() {
    return INSTANCE;
  }

  public void print() {
    System.out.println("operatingSystemProperties2");
  }
}
