package me.swsz2.effectivejava.chapter2.act1;

import lombok.Getter;
import lombok.ToString;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-12, 일요일
 */
@ToString
public class Women extends Human {
  @Getter private final Human.Sex sex = Sex.FEMALE;

  @Override
  public void eat() {
    System.out.println("yummy");
  }
}
