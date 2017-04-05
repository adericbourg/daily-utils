# daily-utils

Don't you repeat yourself across projects? I'm sure you do.
This library aims at providing useful and used code snippets and patterns.

## Typesafe Config

Usage:
```
libraryDependencies += "net.dericbourg.daily-utils" %% "typesafe-config" % "0.1.5"
```

```scala
import net.dericbourg.daily.utils.typesafe.config._
import com.typesafe.config.Config

val config: Config = ???
val timeout = config.getLongOption("some.timeout.value").getOrElse(1000)
```

## Switch between Twitter objects and Scala objects

Usage:
```
libraryDependencies += "net.dericbourg.daily-utils" %% "twitter-utils" % "0.1.5"
```

### Futures

#### Twitter to Scala
```scala
import net.dericbourg.daily.utils.twitter.utils.TwitterConverters._

val twitterFuture = com.twitter.util.future.Future("Hello world!")
val scalaFuture = twitterFuture.asScala
```

#### Scala to Twitter
```scala
import net.dericbourg.daily.utils.twitter.utils.TwitterConverters._

val scalaFuture = scala.concurrent.Future("Hello world!")
val twitterFuture = scalaFuture.asTwitter
```

### Try

#### Twitter to Scala

```scala
import net.dericbourg.daily.utils.twitter.utils.TwitterConverters._

val twitterTry = com.twitter.util.Try {
  whatever()
}
val scalaTry = twitterTry.asScala
```

#### Scala to Twitter

```scala
import net.dericbourg.daily.utils.twitter.utils.TwitterConverters._

val scalaTry = scala.util.Try {
  whatever()
}
val twitterTry = scalaTry.asTwitter
```

## Testing Twitter Futures

Usage:
```
libraryDependencies += "net.dericbourg.daily-utils" %% "twitter-test-future" % "0.1.5" % Test
```

### Using Scalatest

Scalatest provides the trait `ScalaFutures` to test Future results. Here is the same for Twitter Futures:

```scala
import com.twitter.util.future
import net.dericbourg.daily.utils.twitter.future.TwitterFutures

class SomeTest extends YourBaseClass with TwitterFutures {

  "Your test" should "work" in {
    val future = Future("OK")

    whenReady(future) { value =>
      value should be("OK")
    }
  }
}
```
