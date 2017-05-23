package cafe.neso.core.logging

/**
 * Created by moltendorf on 2017-04-30.
 */

val nullLogger = object: NesoLoggerBase() {
  override fun log(label: String, vararg any: Any?) {}
}

var logger = nullLogger

// Logging

infix fun Throwable.trace(message: String) = logger.trace(this, message)
