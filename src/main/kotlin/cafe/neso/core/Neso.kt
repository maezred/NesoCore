package cafe.neso.core

import cafe.neso.core.extension.Bool
import cafe.neso.core.logging.Level
import cafe.neso.core.logging.Level.*
import cafe.neso.core.logging.NesoLogger
import cafe.neso.core.settings.CoreSettings

/**
 * Created by moltendorf on 2017-05-09.
 */

abstract class Neso<T: CoreSettings<T>>(val logger: NesoLogger, val settings: CoreSettings<T>) {
  operator inline fun Level.invoke(block: () -> Unit) {
    if (ordinal >= settings.logging) {
      block()
    }
  }

  fun f(vararg any: Any?) = FINE { logger.fine(any) }
  inline fun f(block: () -> Any?) = FINE { logger.fine(block()) }

  fun i(vararg any: Any?) = INFO { logger.info(any) }
  inline fun i(block: () -> Any?) = INFO { logger.info(block()) }

  fun w(vararg any: Any?) = WARNING { logger.warning(any) }
  inline fun w(block: () -> Any?) = WARNING { logger.warning(block()) }

  fun s(vararg any: Any?) = SEVERE { logger.severe(any) }
  inline fun s(block: () -> Any?) = SEVERE { logger.severe(block()) }

  inline fun test(block: () -> Any?) = TEST { logger.test(block()) }


  inline fun <K, V, C: Map<K, V>> C.testAll(crossinline predicate: (K, V) -> String?): C {
    TEST {
      asSequence().mapNotNull { predicate(it.key, it.value) }.forEach { logger.test(it) }
    }

    return this
  }

  inline fun <K, V, C: Map<K, V>> C.testAll(crossinline predicate: (K, V) -> Bool, message: (K, V) -> Any?): C {
    TEST {
      asSequence().filterNot { predicate(it.key, it.value) }.forEach { logger.test(message(it.key, it.value)) }
    }

    return this
  }

  inline fun <T, C: Iterable<T>> C.testAll(crossinline predicate: (T) -> String?): C {
    TEST {
      asSequence().mapNotNull { predicate(it) }.forEach { logger.test(it) }
    }

    return this
  }

  inline fun <T, C: Iterable<T>> C.testAll(crossinline predicate: (T) -> Bool, message: (T) -> Any?): C {
    TEST {
      asSequence().filterNot { predicate(it) }.forEach { logger.test(message(it)) }
    }

    return this
  }
}
