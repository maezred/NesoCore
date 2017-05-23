package cafe.neso.core.logging

import cafe.neso.core.MapEnum

/**
 * Created by moltendorf on 2017-05-16.
 */

enum class Level {
  SEVERE, WARNING, INFO, FINE, TEST;

  operator fun compareTo(number: Int): Int {
    return ordinal - number
  }

  operator fun Int.compareTo(level: Level): Int {
    return level.ordinal - this
  }

  companion object: MapEnum<Level> by MapEnum()
}
