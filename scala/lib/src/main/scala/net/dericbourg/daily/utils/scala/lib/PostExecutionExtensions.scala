package net.dericbourg.daily.utils.scala.lib

import org.slf4j.LoggerFactory

object PostExecutionExtensions {

  private val logger = LoggerFactory.getLogger(getClass)

  /**
    * Executes a given block on the given resource and run the post-execution block whatever happens.
    *
    * @param resource      Handled resource.
    * @param postExecution Function to be executed whatever happens in the body (eg.: cleanup).
    * @param body          Unsafe function to be executed.
    * @tparam T Resource type.
    * @tparam R Output type.
    * @return Body return over the resource.
    */
  @inline def runWith[T, R](resource: T)(postExecution: T => Unit)(body: T => R): R = {
    try {
      body(resource)
    }
    finally {
      try {
        if (resource != null) {
          postExecution(resource)
        }
      } catch {
        case e: Exception => logger.error("Failed running post-execution process for resource", e)
      }
    }
  }
}
