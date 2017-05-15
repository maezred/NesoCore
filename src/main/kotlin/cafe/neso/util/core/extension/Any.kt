package cafe.neso.util.core.extension

/**
 * Created by moltendorf on 2017-05-09.
 */

inline internal fun <T, R> T.isLet(block: (T) -> R): R? =
  when (this) {
    is T -> block(this)
    else -> null
  }

inline internal fun <reified R> Any?.isAlso(block: (R) -> Unit): R? =
  if (this is R) {
    block(this)
    this
  } else null
