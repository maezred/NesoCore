package cafe.neso.core.extension

/**
 * Created by moltendorf on 2017-05-07.
 */

fun <K, V> Map<out K, V>?.getBool(key: K?): Bool? {
  val bool = this?.get(key)

  return when (bool) {
    is Bool   -> bool
    is String -> bool.toBoolean()
    is Int    -> bool > 0
    is Any    -> bool as? Bool
    else      -> null
  }
}

fun <K, V> Map<out K, V>?.getBool(key: K?, default: Bool) = getBool(key) ?: default
operator fun <K, V> Map<out K, V>?.get(key: K?, default: Bool) = getBool(key, default)

fun <K, V> Map<out K, V>?.getInt(key: K?): Int? {
  val int = this?.get(key)

  return when (int) {
    is Int    -> int
    is String -> int.toIntOrNull()
    is Bool   -> if (int) 1 else 0
    is Any    -> int as? Int
    else      -> null
  }
}

fun <K, V> Map<out K, V>?.getInt(key: K?, default: Int) = getInt(key) ?: default
operator fun <K, V> Map<out K, V>?.get(key: K?, default: Int) = getInt(key, default)

fun <K, V> Map<out K, V>?.getMap(key: K?) = this?.get(key) as? Map<*, *>
fun <K, V> Map<out K, V>?.getMap(key: K?, default: Map<*, *>) = getMap(key) ?: default
operator fun <K, V> Map<out K, V>?.get(key: K?, default: Map<*, *>) = getMap(key, default)

fun <K, V> Map<out K, V>?.getString(key: K?): String? {
  val string = this?.get(key)

  return when (string) {
    is String                                     -> string
    is Bool, is Double, is Float, is Int, is Long -> string.toString()
    else                                          -> null
  }
}

fun <K, V> Map<out K, V>?.getString(key: K?, default: String) = getString(key) ?: default
operator fun <K, V> Map<out K, V>?.get(key: K?, default: String) = getString(key, default)
