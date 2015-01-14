---
layout: home
title: home
version: 0.4.0
---


```java
import org.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", (req) ->
      "Hey Jooby!"
    );
  }

  public static void main(final String[] args) throws Exception {
    new App().start(args);
  }
}

```