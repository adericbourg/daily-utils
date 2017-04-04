package net.dericbourg.daily.utils.twitter.utils

package util

import com.twitter.{util => twitter}

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success, Try}

object TwitterConverters {

  implicit class ScalaToTwitterTry[T](t: Try[T]) {
    def asTwitter: twitter.Try[T] = {
      t match {
        case Success(r) => twitter.Return(r)
        case Failure(ex) => twitter.Throw(ex)
      }
    }
  }

  implicit class TwitterToScalaTry[T](t: twitter.Try[T]) {
    def asScala: Try[T] = t match {
      case twitter.Return(r) => Success(r)
      case twitter.Throw(ex) => Failure(ex)
    }
  }

  implicit class ScalaToTwitterFuture[T](f: Future[T]) {
    def asTwitter(implicit ec: ExecutionContext): twitter.Future[T] = {
      val promise = twitter.Promise[T]()
      f.onComplete(promise update _.asTwitter)
      promise
    }
  }

  implicit class TwitterToScalaFuture[T](f: twitter.Future[T]) {
    def asScala: Future[T] = {
      val promise = Promise[T]()
      f.respond(promise complete _.asScala)
      promise.future
    }
  }

}
