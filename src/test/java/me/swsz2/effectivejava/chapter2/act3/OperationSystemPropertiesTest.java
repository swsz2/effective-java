package me.swsz2.effectivejava.chapter2.act3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;

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
      Assertions.assertThrows(AssertionError.class, constructor::newInstance);
    }
  }

  @Test
  public void testOperationSystemProperties2() throws IOException, ClassNotFoundException {

    final int hashCode = OperatingSystemProperties2.getInstance().hashCode();
    final File serialized = new File("serialized");

    // serialize
    try (final FileOutputStream fileOutputStream = new FileOutputStream(serialized);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(OperatingSystemProperties2.getInstance());

      // deserialize
      try (final FileInputStream fileInputStream = new FileInputStream(serialized);
          final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

        // then
        Assertions.assertEquals(hashCode, objectInputStream.readObject().hashCode());
        /* result of remove OperatingSystemProperties2.readResolve
          org.opentest4j.AssertionFailedError:
          Expected :645482568
          Actual   :1233705144
        */
      }
    } finally {
      Files.delete(serialized.toPath());
    }
  }
}
