package cafe.neso.util.core.logging

import cafe.neso.util.core.extension.Bool

/**
 * Created by moltendorf on 2017-04-30.
 */

val instance get() = NesoLogger.nullLogger

// Logging

fun f(message: String) = instance.fine(message)
inline fun f(block: () -> Any?) {
  if (instance.fineEnabled) f("${block()}")
}

fun i(message: String) = instance.info(message)
inline fun i(block: () -> Any?) {
  if (instance.infoEnabled) i("${block()}")
}

fun w(message: String) = instance.warning(message)
inline fun w(block: () -> Any?) {
  if (instance.warningEnabled) w("${block()}")
}

infix fun Throwable.trace(message: String) = instance.trace(this, message)

inline fun test(block: () -> Any?) {
  if (instance.testEnabled) {
    i(block)
  }
}

internal inline fun <T, C: Iterable<T>> C.test(predicate: (T) -> Bool, message: (T) -> Any?): C {
  if (instance.testEnabled) {
    filter { predicate(it) }.forEach { i { message(it) } }
  }

  return this
}
