package net.dericbourg.daily.utils.twitter.util.future

import com.twitter.util.{Return, Throw}
import org.scalatest.concurrent.Futures

trait TwitterFutures extends Futures {

  import scala.language.implicitConversions

  implicit def convertTwitterFuture[T](twitterFuture: com.twitter.util.Future[T]): FutureConcept[T] =
    new FutureConcept[T] {
      def eitherValue: Option[Either[Throwable, T]] =
        twitterFuture.poll.map {
          case Return(value) => Right(value)
          case Throw(throwable) => Left(throwable)
        }

      def isExpired: Boolean = false

      def isCanceled: Boolean = false
    }
}

object TwitterFutures extends TwitterFutures
