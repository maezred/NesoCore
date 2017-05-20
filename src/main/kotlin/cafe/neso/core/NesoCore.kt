package cafe.neso.core

import cafe.neso.core.logging.NesoLogger
import cafe.neso.core.settings.CoreSettings

/**
 * Created by moltendorf on 2017-05-16.
 */

abstract class NesoCore(override val settings: CoreSettings, override val logger: NesoLogger): Neso
