package cafe.neso.util.core

import java.util.logging.*

/**
 * Created by moltendorf on 2017-05-09.
 */

interface Core {
  val logger: Logger

  companion object {
    lateinit var instance: Core

    operator fun invoke(builder: () -> Core) {
      instance = builder()
    }
  }
}
