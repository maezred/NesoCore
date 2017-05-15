package cafe.neso.util.core.logging

import cafe.neso.util.core.extension.Bool

/**
 * Created by moltendorf on 2017-05-09.
 */

interface NesoLogger {
  val fineEnabled: Bool
  val infoEnabled: Bool
  val warningEnabled: Bool
  val testEnabled: Bool

  fun fine(vararg any: Any?)
  fun info(vararg any: Any?)
  fun warning(vararg any: Any?)
  fun severe(vararg any: Any?)
  fun trace(thrown: Throwable, vararg any: Any?)

  fun test(vararg any: Any?)

  companion object {
    val nullLogger = object: NesoLoggerBase() {
      override fun log(label: String, vararg any: Any?) {}
    }
  }
}
