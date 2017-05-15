package cafe.neso.util.core.logging

/**
 * Created by moltendorf on 2017-05-09.
 */

abstract class NesoLoggerBase: NesoLogger {
  override val fineEnabled = false
  override val warningEnabled = true

  override val infoEnabled get() = warningEnabled
  override val testEnabled get() = fineEnabled

  abstract fun log(label: String, vararg any: Any?)

  override fun fine(vararg any: Any?) = log("[FINE]", any)
  override fun info(vararg any: Any?) = log("[INFO]", any)
  override fun warning(vararg any: Any?) = log("[WARN]", any)
  override fun severe(vararg any: Any?) = log("[SEVERE]", any)
  override fun trace(thrown: Throwable, vararg any: Any?) = log("[SEVERE]", any)
  override fun test(vararg any: Any?) = log("[TEST]", any)
}
