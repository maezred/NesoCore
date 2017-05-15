package cafe.neso.util.core.extension

/**
 * Created by moltendorf on 2017-05-07.
 */

internal fun <K, V> Map<out K, V>?.getBool(key: K?): Bool? {
  val bool = this?.get(key)

  return when (bool) {
    is Bool   -> bool
    is String -> bool.toBoolean()
    is Int    -> bool > 0
    is Any    -> bool as? Bool
    else      -> null
  }
}

internal fun <K, V> Map<out K, V>?.getBool(key: K?, default: Bool) = getBool(key) ?: default
internal operator fun <K, V> Map<out K, V>?.get(key: K?, default: Bool) = getBool(key, default)

internal fun <K, V> Map<out K, V>?.getInt(key: K?): Int? {
  val int = this?.get(key)

  return when (int) {
    is Int    -> int
    is String -> int.toIntOrNull()
    is Bool   -> if (int) 1 else 0
    is Any    -> int as? Int
    else      -> null
  }
}

internal fun <K, V> Map<out K, V>?.getInt(key: K?, default: Int) = getInt(key) ?: default
internal operator fun <K, V> Map<out K, V>?.get(key: K?, default: Int) = getInt(key, default)

internal fun <K, V> Map<out K, V>?.getMap(key: K?) = this?.get(key) as? Map<*, *>
internal fun <K, V> Map<out K, V>?.getMap(key: K?, default: Map<*, *>) = getMap(key) ?: default
internal operator fun <K, V> Map<out K, V>?.get(key: K?, default: Map<*, *>) = getMap(key, default)

internal fun <K, V> Map<out K, V>?.getString(key: K?): String? {
  val string = this?.get(key)

  return when (string) {
    is String                                     -> string
    is Bool, is Double, is Float, is Int, is Long -> string.toString()
    else                                          -> null
  }
}

internal fun <K, V> Map<out K, V>?.getString(key: K?, default: String) = getString(key) ?: default
internal operator fun <K, V> Map<out K, V>?.get(key: K?, default: String) = getString(key, default)
