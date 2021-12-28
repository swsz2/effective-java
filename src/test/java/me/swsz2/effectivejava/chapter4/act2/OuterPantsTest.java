package me.swsz2.effectivejava.chapter4.act2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-28, 화요일
 */
public class OuterPantsTest {

  @Test
  public void testOuter() {

    Outer outer = new Outer();
    outer.setLength(10);
    outer.setLength(10);

    Assertions.assertEquals(outer.getLength(), 10);
    Assertions.assertEquals(outer.getWidth(), 10);

  }

  @Test
  public void testPants() {

    Pants pants = new Pants.Builder(10, 10).rise(20).build();

    Assertions.assertEquals(pants.length, 10);
    Assertions.assertEquals(pants.width, 10);
    Assertions.assertEquals(pants.rise, 20);

  }
}
