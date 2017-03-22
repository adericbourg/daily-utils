package net.dericbourg.daily.utils.twitter.util.future

import com.twitter.util.Future
import org.scalatest.{MustMatchers, WordSpec}

class TwitterFuturesSpec extends WordSpec with MustMatchers {

  "The Either value of a successful Twitter future" should {
    "be a Some(Right)" in {
      val value = 1
      val f = Future(value)

      val either = TwitterFutures.convertTwitterFuture(f).eitherValue

      either must be(Some(Right(value)))
    }
  }

  "The Either value of a failed Twitter future" should {
    "be a Some(Left)" in {
      val exception = new RuntimeException()
      val f = Future.exception(exception)

      val either = TwitterFutures.convertTwitterFuture(f).eitherValue

      either must be(Some(Left(exception)))
    }
  }
}
