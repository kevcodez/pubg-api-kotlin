package de.kevcodez.pubg.model.match

open class Participant : MatchObject() {
    var id: String = ""
    var actor: String = ""
    var shardId: String = ""
    lateinit var attributes: ParticipantAttributes
}

data class ParticipantAttributes(
    val stats: ParticipantStats,
    val actor: String,
    val shardId: String
)

data class ParticipantStats(
    val DBNOs: Int,
    val assists: Int,
    val boosts: Int,
    val damageDealt: Double,
    val deathType: String?,
    val headshotKills: Int,
    val heals: Int,
    val killPlace: Int,
    val killPoints: Int,
    val killPointsDelta: Int,
    val killStreaks: Int,
    val kills: Int,
    val lastKillPoints: Int,
    val lastWinPoints: Int,
    val longestKill: Double,
    val mostDamage: Int,
    val name: String?,
    val playerId: String,
    val revives: Int,
    val rideDistance: Double,
    val roadKills: Int,
    val teamKills: Int,
    val timeSurvived: Double,
    val vehicleDestroys: Int,
    val walkDistance: Double,
    val weaponsAcquired: Int,
    val winPlace: Int,
    val winPoints: Int,
    val winPointsDelta: Double,
    val swimDistance: Double
)
