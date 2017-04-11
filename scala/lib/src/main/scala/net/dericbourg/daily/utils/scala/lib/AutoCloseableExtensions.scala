package net.dericbourg.daily.utils.scala.lib

import scala.language.reflectiveCalls

object AutoCloseableExtensions {

  /**
    * Safely executes a given block on this resource.
    * The resource is guaranteed to be closed after the method returns,
    * regardless of whether an exception is thrown or not.
    */
  @inline def use[T <: {def close() : Unit}, R](resource: T)(block: T => R): R = {
    PostExecutionExtensions.runWith(resource)(_.close()) { r =>
      block(r)
    }
  }

}