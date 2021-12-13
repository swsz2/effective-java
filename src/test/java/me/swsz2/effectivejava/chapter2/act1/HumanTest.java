package me.swsz2.effectivejava.chapter2.act1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-12, 일요일
 */
class HumanTest {

  @Test
  void testCreate() {

    final Human women = Human.create(Human.Sex.FEMALE);

    Assertions.assertNotNull(women);
    Assertions.assertInstanceOf(Women.class, women);
    Assertions.assertEquals(Human.Sex.FEMALE, ((Women) women).getSex());

    final Human man = Human.create(Human.Sex.MALE);

    Assertions.assertNotNull(man);
    Assertions.assertInstanceOf(Man.class, man);
    Assertions.assertEquals(Human.Sex.MALE, ((Man) man).getSex());
  }

  @Test
  void testFrom() {

    final Human womenFrom = Human.create(Human.Sex.FEMALE);
    final Human womenInstance = Human.getWomenInstance();

    Assertions.assertNotNull(womenFrom);
    Assertions.assertNotNull(womenInstance);
    Assertions.assertInstanceOf(Women.class, womenFrom);
    Assertions.assertInstanceOf(Women.class, womenInstance);
    Assertions.assertNotEquals(womenFrom, womenInstance);

    final Human manFrom = Human.create(Human.Sex.MALE);
    final Human manInstance = Human.newManInstance();

    Assertions.assertNotNull(manFrom);
    Assertions.assertNotNull(manInstance);
    Assertions.assertInstanceOf(Man.class, manFrom);
    Assertions.assertInstanceOf(Man.class, manInstance);
    Assertions.assertNotEquals(manFrom, manInstance);
  }

  @Test
  void testInstance() {

    final Human womenCreate = Human.create(Human.Sex.FEMALE);
    final Human womenInstance = Human.newWomenInstance();

    Assertions.assertNotNull(womenCreate);
    Assertions.assertNotNull(womenInstance);
    Assertions.assertInstanceOf(Women.class, womenCreate);
    Assertions.assertInstanceOf(Women.class, womenInstance);
    Assertions.assertNotEquals(womenCreate, womenInstance);

    final Human manCreate = Human.create(Human.Sex.MALE);
    final Human manInstance = Human.newManInstance();

    Assertions.assertNotNull(manCreate);
    Assertions.assertNotNull(manInstance);
    Assertions.assertInstanceOf(Man.class, manCreate);
    Assertions.assertInstanceOf(Man.class, manInstance);
    Assertions.assertNotEquals(manCreate, manInstance);
  }

  @Test
  void testEat() {

    final Human womenInstance = Human.getWomenInstance();
    final Human manInstance = Human.getManInstance();

    Assertions.assertNotNull(womenInstance);
    Assertions.assertNotNull(manInstance);
    Assertions.assertInstanceOf(Women.class, womenInstance);
    Assertions.assertInstanceOf(Man.class, manInstance);

    womenInstance.eat();
    manInstance.eat();
  }
}
