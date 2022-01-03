package me.swsz2.effectivejava.chapter4.act8;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2022-01-03, 월요일
 */
public class Product implements Prices {
  private final long COAT = 10000;
  private final long PANTS = 10000;
  private final long SHIRT = 10000;

  public void printPrices() {
    System.out.println("COAT = " + COAT);
    System.out.println("PANTS = " + PANTS);
    System.out.println("SHIRT = " + SHIRT);
  }
}
