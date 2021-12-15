package me.swsz2.effectivejava.chapter2.act4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-15, 수요일
 */
class StringUtilsTest {

  @Test
  public void testCreateStringUtils() {
    // reflection
    Constructor<?>[] constructors = StringUtils.class.getDeclaredConstructors();
    for (Constructor<?> constructor : constructors) {
      constructor.setAccessible(true);
      Assertions.assertThrows(InvocationTargetException.class, constructor::newInstance);
    }
  }
}
