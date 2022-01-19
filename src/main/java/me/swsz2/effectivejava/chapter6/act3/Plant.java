package me.swsz2.effectivejava.chapter6.act3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Plant {

  enum LifeCycle {
    ANNUAL,
    PERENNIAL,
    BIENNIAL
  }

  final String name;
  final LifeCycle lifeCycle;
}
