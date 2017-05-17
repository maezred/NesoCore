package cafe.neso.core.settings

import cafe.neso.core.settings.delegate.prop

/**
 * Created by moltendorf on 2017-05-09.
 */

abstract class CoreSettings(): Settings() {
  var enabled by prop(true)
}
