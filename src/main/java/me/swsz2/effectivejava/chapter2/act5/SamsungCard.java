package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public class SamsungCard extends Card {

  public SamsungCard(String owner, String number) {
    super(owner, number);
  }

  @Override
  public void read() {
    System.out.println("type : SamsungCard, Owner : " + owner + ", Number : " + number);
  }
}
