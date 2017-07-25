package net.dericbourg.daily.utils.scala.lib

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpec}

import scala.util.{Failure, Try}

class AutoCloseableExtensionsTest extends WordSpec with MockFactory with Matchers {

  "use" should {
    "run block and close resource" in {

      import AutoCloseableExtensions.use

      val innerBlock = mock[Runnable]
      (innerBlock.run _).expects().once()
      val resource = mock[AutoCloseable]
      (resource.close _).expects().once()


      use(resource) { a: AutoCloseable =>
        a should not be null

        innerBlock.run()
      }

    }

    "close resource even after an exception occurred" in {
      import AutoCloseableExtensions.use

      val resource = mock[AutoCloseable]
      (resource.close _).expects().once()

      val tryResult = Try {
        use(resource) { _ =>
          throw new RuntimeException("Expected")
        }
      }

      tryResult match {
        case Failure(e) => e.getMessage shouldEqual "Expected"
        case _ => fail("Unexpected behavior")
      }
    }

    "not fail if resource was null" in {
      import AutoCloseableExtensions.use

      val resource: AutoCloseable = null
      use(resource) { r =>
        r should be(null)
      }
    }
  }
}
