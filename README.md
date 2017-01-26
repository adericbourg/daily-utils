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
