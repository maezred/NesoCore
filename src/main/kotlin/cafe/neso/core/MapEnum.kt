package cafe.neso.core

/**
 * Created by moltendorf on 2017-05-19.
 */
interface MapEnum<E: Enum<E>> {
  operator fun get(name: String): E?
  operator fun get(ordinal: Int): E?

  companion object {
    operator inline fun <reified E: Enum<E>> invoke(): MapEnum<E> {
      val ordinals = enumValues<E>()

      return MapEnumBase(ordinals)
    }
  }
}
