package cafe.neso.core.logging

/**
 * Created by moltendorf on 2017-05-09.
 */

abstract class NesoLoggerBase: NesoLogger {
  abstract fun log(label: String, vararg any: Any?)

  override fun fine(vararg any: Any?) = log("[FINE]")
  override fun info(vararg any: Any?) = log("[INFO]", any)
  override fun warning(vararg any: Any?) = log("[WARNING]", any)
  override fun severe(vararg any: Any?) = log("[SEVERE]", any)
  override fun trace(thrown: Throwable, vararg any: Any?) = log("[SEVERE]", any)
  override fun test(vararg any: Any?) = log("[TEST]", any)
}
