package cafe.neso.core.settings.delegate

import cafe.neso.core.settings.SettingsInterface
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by moltendorf on 2017-05-16.
 */
/**
 * Created by moltendorf on 2017-05-16.
 */

class prop<in R: SettingsInterface, T>(val default: T): ReadWriteProperty<R, T?> {
  var value = default

  override operator fun getValue(thisRef: R, property: KProperty<*>): T {
    return value
  }

  override operator fun setValue(thisRef: R, property: KProperty<*>, value: T?) {
    this.value = value ?: default
  }
}
