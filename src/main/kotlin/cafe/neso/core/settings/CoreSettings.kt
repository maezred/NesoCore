package cafe.neso.core.settings

import cafe.neso.core.logging.Level
import cafe.neso.core.settings.delegate.prop

/**
 * Created by moltendorf on 2017-05-09.
 */

abstract class CoreSettings<T: CoreSettings<T>>: Settings<T>() {
  var enabled by prop(true)
  var logging by prop(Level.INFO)
}
