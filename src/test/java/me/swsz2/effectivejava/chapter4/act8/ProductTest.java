package me.swsz2.effectivejava.chapter4.act8;

import org.junit.jupiter.api.Test;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2022-01-03, 월요일
 */
public class ProductTest {

  @Test
  public void testPrintPrices() {

    // constants in Prices(interface)
    // static final long COAT = 80000;
    // static final long PANTS = 30000;
    // static final long SHIRT = 90000;

    // class constants in Product.class
    // private final long COAT = 10000;
    // private final long PANTS = 10000;
    // private final long SHIRT = 10000;
    Product product = new Product();
    product.printPrices();
  }
}
