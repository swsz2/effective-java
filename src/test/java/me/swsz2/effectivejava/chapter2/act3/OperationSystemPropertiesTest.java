package me.swsz2.effectivejava.chapter2.act3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-14, 화요일
 */
public class OperationSystemPropertiesTest {

  @Test
  public void testOperationSystemProperties() {
    // reflection
    Constructor<?>[] constructors = OperatingSystemProperties.class.getDeclaredConstructors();
    for (Constructor<?> constructor : constructors) {
      constructor.setAccessible(true);
      Assertions.assertThrows(InstantiationError.class, constructor::newInstance);
    }
  }

  @Test
  public void testOperationSystemProperties2() throws IOException, ClassNotFoundException {

    final int hashCode = OperatingSystemProperties2.getInstance().hashCode();

    // serialize
    try (final FileOutputStream fileOutputStream =
            new FileOutputStream("OperationSystemProperties2.ser");
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(OperatingSystemProperties2.getInstance());

      // deserialize
      try (final FileInputStream fileInputStream =
              new FileInputStream("OperationSystemProperties2.ser");
          final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

        // then
        Assertions.assertEquals(hashCode, objectInputStream.readObject().hashCode());
        /* result of remove OperatingSystemProperties2.readResolve
          org.opentest4j.AssertionFailedError:
          Expected :645482568
          Actual   :1233705144
        */
      }
    }
  }
}
