PUBG API wrapper written in Kotlin. Requires Java 1.8+. 

[Official API Page](https://developer.playbattlegrounds.com)

![Maven metadata URI](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/de/kevcodez/pubg/pubg-api-wrapper/maven-metadata.xml.svg)
 [![Build Status](https://travis-ci.org/kevcodez/pubg-api-kotlin.svg?branch=master)](https://travis-ci.org/kevcodez/pubg-api-kotlin)
[![GitHub license](https://img.shields.io/github/license/kevcodez/pubg-api-kotlin.svg)](https://github.com/kevcodez/pubg-api-kotlin/blob/master/LICENSE)

- [Getting started](#getting-started)
  * [Maven](#maven)
  * [Gradle](#gradle)
  * [API Key](#api-key)
  * [First request](#first-request)
  * [Players](#players)
    + [Searching for players by id/name](#searching-for-players-by-id-name)
    + [Searching for player by ID](#searching-for-player-by-id)
  * [Matches](#matches)
    + [Searching for match by ID](#searching-for-match-by-id)
  * [Tournaments](#tournaments)
    + [Get all tournmanets](#get-all-tournmanets)
    + [Get tournament by ID](#get-tournament-by-id)
  * [Status](#status)
  * [Telemetry data](#telemetry-data)
- [Implementation](#implementation)
- [Links](#links)

# Getting started

The releases are pushed to maven central. Include the latest release in your build file.

## Maven
```xml
<dependency>
    <groupId>de.kevcodez.pubg</groupId>
    <artifactId>pubg-api-wrapper</artifactId>
    <version>0.3.0</version>
</dependency>
```

## Gradle

```groovy
compile "de.kevcodez.pubg:pubg-api-wrapper:0.3.0"
```

## API Key

If you do not have an API key yet, go to the [Official API Page](https://developer.playbattlegrounds.com) and register.

## First request

```kotlin
val apiClient = ApiClient("my-key", OkHttpClient())

val match = apiClient.getMatch(Region.PC_EUROPE, "id")
println(match.duration)
```

You can configure the [OkHttp3 Client](http://square.github.io/okhttp/) to register proxies or interceptors.

## Players

You can search for players by their ID/name or get information about a specific player.

### Searching for players by id/name

```kotlin
val playerResponse = apiClient.getPlayers(Region.PC_NORTH_AMERICA, PlayerFilter(playerNames = listOf("shroud")))
playerResponse.players.forEach { 
    println(it.id)
}
```

### Searching for player by ID

```kotlin
val playerResponse = apiClient.getPlayer(Region.PC_EUROPE, "<id>")
playerResponse.players.forEach { 
    println(it.id)
}
```

## Matches

You can only search for concrete matches by ID.

### Searching for match by ID

```kotlin
val apiClient = ApiClient("my-key", OkHttpClient())

val match = apiClient.getMatch(Region.PC_EUROPE, "id")
println(match.duration)
```

## Tournaments

### Get all tournmanets

```kotlin
val apiClient = ApiClient("my-key", OkHttpClient())
val tournaments = apiClient.getTournaments()
```

### Get tournament by ID

```kotlin
val apiClient = ApiClient("my-key", OkHttpClient())
val tournament = apiClient.getTournament("<id>")
```

## Status

```kotlin
val status = apiClient.getStatus()
println(status.releasedAt)
println(status.version)
```

## Telemetry data

Check the de.kevcodez.pubg.model.telemetry package for all structures. The telemetry data contains a list of telemetry events.

```kotlin
val telemetryData = apiClient.getTelemetryData("url")

telemetryData.filter { it is PlayerKill }.map { it as PlayerKill }.forEach {
    println("Kill at ${it.timestamp}")
    println("Killer: ${it.killer}")
    println("Victim: ${it.victim}")
}
```

Prints

> Kill at 2018-04-15T15:13:08.912Z
>  Killer: Character(name=sen10za, teamId=44, health=100.0, location=Location(x=415623.0, y=465934.06, z=3607.5898), ranking=0, accountId=account.116f300334ef4310bdbe2e5e51253663)
>  Victim: Character(name=sen10za, teamId=44, health=100.0, location=Location(x=415623.0, y=465934.06, z=3607.5898), ranking=0, accountId=account.116f300334ef4310bdbe2e5e51253663)
>  Kill at 2018-04-15T15:13:55.544Z
>  Killer: Character(name=Muzhik_Raketa, teamId=15, health=100.0, location=Location(x=408639.56, y=456094.12, z=4953.4897), ranking=0, accountId=account.6083879a56a1403c964af920e2b6534e)
>  Victim: Character(name=Muzhik_Raketa, teamId=15, health=100.0, location=Location(x=408639.56, y=456094.12, z=4953.4897), ranking=0, accountId=account.6083879a56a1403c964af920e2b6534e)
>  Kill at 2018-04-15T15:14:53.828Z
>  Killer: Character(name=kavek, teamId=15, health=90.0, location=Location(x=408673.34, y=457988.9, z=4938.0), ranking=0, accountId=account.00044da12eda458d9d493ae7f7cf87db)
>  Victim: Character(name=kavek, teamId=15, health=90.0, location=Location(x=408673.34, y=457988.9, z=4938.0), ranking=0, accountId=account.00044da12eda458d9d493ae7f7cf87db)


# Implementation

The [OkHttp3](http://square.github.io/okhttp/) client is used as HTTP client. During the creation of the API client, you can register your own OkHttpClient and register interceptors, proxies, etc.

For parsing the JSON responses, [Jackson FasterXML](https://github.com/FasterXML/jackson) is used.

# Links

[Official Documentation](https://developer.playbattlegrounds.com)

[Official assets, like images, and dictionaries](https://github.com/pubg/api-assets).
