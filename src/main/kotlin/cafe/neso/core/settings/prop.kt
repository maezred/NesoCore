package cafe.neso.core.settings

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by moltendorf on 2017-05-15.
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
