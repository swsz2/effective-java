package me.swsz2.effectivejava.chapter6.act8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassTest {

  @Test
  public void testAnonymousClass() {
    List<Integer> integers = Arrays.asList(13, 67, 3, 45, 5, 346, 34, 63);
    Collections.sort(
        integers,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
          }
        });
    System.out.println("integers = " + integers);
  }

  @Test
  public void testLambda() {
    List<Integer> integers = Arrays.asList(13, 67, 3, 45, 5, 346, 34, 63);
    Collections.sort(integers, Comparator.comparingInt(o -> o));
    System.out.println("integers = " + integers);
  }
}
