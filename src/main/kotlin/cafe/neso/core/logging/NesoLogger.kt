package cafe.neso.core.logging

/**
 * Created by moltendorf on 2017-05-09.
 */

interface NesoLogger {
  fun fine(vararg any: Any?)
  fun info(vararg any: Any?)
  fun warning(vararg any: Any?)
  fun severe(vararg any: Any?)
  fun trace(thrown: Throwable, vararg any: Any?)

  fun test(vararg any: Any?)
}
