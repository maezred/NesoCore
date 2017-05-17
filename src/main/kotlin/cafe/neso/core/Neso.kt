package cafe.neso.core

import cafe.neso.core.logging.NesoLogger

/**
 * Created by moltendorf on 2017-05-09.
 */

interface Neso {
  val logger: NesoLogger

  companion object {
    lateinit var neso: Neso
  }
}
