package cafe.neso.core.settings

import cafe.neso.core.settings.delegate.prop
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Created by moltendorf on 2017-05-15.
 */

abstract class Settings<S: Settings<S>>: SettingsInterface {
  inline fun <T> default(block: KClass<out Settings<S>>.() -> prop<*, KProperty<T>>) {
    val property = block(this::class)

    property.current = property.default
  }
}
