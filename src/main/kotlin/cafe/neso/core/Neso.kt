package cafe.neso.core

import cafe.neso.core.logging.NesoLogger
import cafe.neso.core.settings.CoreSettings

/**
 * Created by moltendorf on 2017-05-09.
 */

interface Neso<T: CoreSettings<T>> {
  val logger: NesoLogger
  val settings: CoreSettings<T>

  companion object {
    lateinit internal var neso: Neso<*>
  }
}
