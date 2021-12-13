package me.swsz2.effectivejava.chapter2.act2;

import org.junit.jupiter.api.Test;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-13, 월요일
 */
class PromotionTest {

  @Test
  public void testPromotion() {

    Promotion constructor = new Promotion(true, false, true, true);
    Promotion builder = new Promotion.Builder().student().ministry().recommender().build();

    System.out.println("constructor = " + constructor);
    System.out.println("builder = " + builder);

    // constructor = Promotion(student=true, sat=false, ministry=true, recommender=true)
    // builder = Promotion(student=true, sat=false, ministry=true, recommender=true)
  }
}
