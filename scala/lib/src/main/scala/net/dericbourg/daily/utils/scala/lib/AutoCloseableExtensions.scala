package net.dericbourg.daily.utils.scala.lib

object AutoCloseableExtensions {

  /**
    * Safely executes a given block on this resource.
    * The resource is guaranteed to be closed after the method returns,
    * regardless of whether an exception is thrown or not.
    */
  @inline def use[T <: AutoCloseable, R](resource: T)(block: T => R): R = {
    try {
      block(resource)
    } finally {
      resource.close()
    }
  }

}