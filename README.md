PUBG API wrapper written in Kotlin. Requires Java 1.8+. 

[Official API Page](https://developer.playbattlegrounds.com)

# Usage

```kotlin
val apiClient = ApiClient("my-key", OkHttpClient())

val match = apiClient.getMatch(Region.PC_EUROPE, "id")
println(match.duration)
```

# Information

The [OkHttp3](http://square.github.io/okhttp/) client is used as HTTP client. During the creation of the API client, you can register your own OkHttpClient and register interceptors, proxies, etc.

For parsing the JSON responses, [Jackson FasterXML](https://github.com/FasterXML/jackson) is used.

This project is still early in development, I don't even have an API key to try this project out yet.
