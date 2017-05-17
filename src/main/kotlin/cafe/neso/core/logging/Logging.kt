package cafe.neso.core.logging

import cafe.neso.core.extension.Bool

/**
 * Created by moltendorf on 2017-04-30.
 */

val nullLogger = object: NesoLoggerBase() {
  override fun log(label: String, vararg any: Any?) {}
}

var logger = nullLogger

// Logging

fun f(message: String) = logger.fine(message)

inline fun f(block: () -> Any?) {
  if (logger.fineEnabled) f("${block()}")
}

fun i(message: String) = logger.info(message)

inline fun i(block: () -> Any?) {
  if (logger.infoEnabled) i("${block()}")
}

fun w(message: String) = logger.warning(message)

inline fun w(block: () -> Any?) {
  if (logger.warningEnabled) w("${block()}")
}

infix fun Throwable.trace(message: String) = logger.trace(this, message)

inline fun test(block: () -> Any?) {
  if (logger.testEnabled) {
    i(block)
  }
}

inline fun <T, C: Iterable<T>> C.test(predicate: (T) -> Bool, message: (T) -> Any?): C {
  if (logger.testEnabled) {
    filter { predicate(it) }.forEach { i { message(it) } }
  }

  return this
}
