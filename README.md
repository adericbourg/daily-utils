#daily-utils

Don't you repeat yourself across projects? I'm sure you do. 
This library aims at providing useful and used code snippets and patterns. 
 
## Typesafe Config
 
```scala
import net.dericbourg.daily.utils.typesafe.config._
import com.typesafe.config.Config

val config: Config = ???
val timeout = config.getLongOption("some.timeout.value").getOrElse(1000)
```

## Testing Twitter Futures

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
