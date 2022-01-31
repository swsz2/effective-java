package me.swsz2.effectivejava.chapter6.act11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2022-01-31, 월요일
 */
public class StreamTest {
  /** 원소들의 시퀀스를 일관성 있게 변환할 때 */
  @Test
  void testToUpperCase() {

    // list
    List<String> firstNames = Arrays.asList("lee", "choi", "kim", "moon", "park");
    for (String firstName : firstNames) {
      System.out.println(firstName.toUpperCase());
    }

    // stream
    Stream.of("lee", "choi", "kim", "moon", "park")
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }

  /** 원소들의 시퀀스를 연산 후 결합할 때 */
  @Test
  public void testAdd() {
    // list
    List<Integer> integers =
        Arrays.asList(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5);
    int sum = 0;
    for (Integer integer : integers) {
      sum += integer;
    }
    System.out.println("sum = " + sum);

    // stream
    System.out.println(
        "sum = "
            + Stream.of(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5)
                .mapToInt(i -> i)
                .sum());
  }

  /** 원소들의 시퀀스를 필터링할 때 */
  @Test
  public void testFilter() {
    // list
    List<Integer> integers =
        Arrays.asList(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5);
    for (Integer integer : integers) {
      if (integer % 2 == 0) {
        System.out.println(integer);
      }
    }

    // stream
    Stream.of(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5)
        .filter(i -> i % 2 == 0)
        .forEach(System.out::println);
  }

  /** 원소들의 시퀀스를 모을 때 */
  @Test
  public void testCollect() {
    // stream
    List<Integer> integers =
        Stream.of(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5)
            .filter(i -> i % 2 == 0)
            .collect(Collectors.toList());
    integers.forEach(System.out::println);
  }

  @Test
  public void findTest() {
    Stream.of(1, 2, 3, 4, 6, 8, 1, 4567, 3, 653, 563, 46, 456, 14, 23, 6243, 534, 5)
        .filter(i -> i == 6243)
        .findAny()
        .ifPresent(System.out::println);
  }
}
