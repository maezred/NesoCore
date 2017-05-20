package cafe.neso.core.tests

import cafe.neso.core.logging.Level
import cafe.neso.core.logging.Level.INFO
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by moltendorf on 2017-05-19.
 */

class MapEnumTests {
  @Test fun testLevelEnum() {
    assertEquals(INFO, Level["info"])
    assertEquals(INFO, Level["INFO"])
    assertEquals(null, Level["iNfO"])
  }
}
