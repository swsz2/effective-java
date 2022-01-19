package me.swsz2.effectivejava.chapter6.act3;

import java.util.EnumMap;

public class PlantStore {

  private EnumMap<Plant.LifeCycle, String> map;

  public PlantStore() {
    this.map = new EnumMap<>(Plant.LifeCycle.class);
    map.put(Plant.LifeCycle.ANNUAL, "ANNUAL");
    map.put(Plant.LifeCycle.BIENNIAL, "BIENNIAL");
    map.put(Plant.LifeCycle.PERENNIAL, "PERENNIAL");
  }
}
