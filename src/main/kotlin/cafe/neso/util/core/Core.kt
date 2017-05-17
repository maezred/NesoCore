package cafe.neso.util.core

import cafe.neso.core.logging.NesoLogger

/**
 * Created by moltendorf on 2017-05-09.
 */

interface Core {
  val logger: NesoLogger

  companion object {
    lateinit var neso: Core

    operator fun invoke(builder: () -> Core) {
      neso = builder()
    }
  }
}
