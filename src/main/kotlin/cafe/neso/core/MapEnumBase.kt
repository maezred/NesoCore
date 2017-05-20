package cafe.neso.core

/**
 * Created by moltendorf on 2017-05-19.
 */

class MapEnumBase<E: Enum<E>>(private val ordinals: Array<E>): MapEnum<E> {
  private val names = ordinals.associate { it.name.intern() to it }
    .plus(ordinals.associate { it.name.toLowerCase().intern() to it })
    .plus(ordinals.associate { it.name.toUpperCase().intern() to it })

  override fun get(name: String): E? = names[name]
  override fun get(ordinal: Int): E? = ordinals[ordinal]
}
