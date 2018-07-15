package de.kevcodez.pubg.model.telemetry.events

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import de.kevcodez.pubg.model.telemetry.objects.Common
import java.time.Instant

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_T")
@JsonSubTypes(
    JsonSubTypes.Type(value = PlayerLogin::class, name = "LogPlayerLogin"),
    JsonSubTypes.Type(value = PlayerCreate::class, name = "LogPlayerCreate"),
    JsonSubTypes.Type(value = PlayerPosition::class, name = "LogPlayerPosition"),
    JsonSubTypes.Type(value = PlayerAttack::class, name = "LogPlayerAttack"),
    JsonSubTypes.Type(value = ItemPickup::class, name = "LogItemPickup"),
    JsonSubTypes.Type(value = ItemUnequip::class, name = "LogItemUnequip"),
    JsonSubTypes.Type(value = ItemEquip::class, name = "LogItemEquip"),
    JsonSubTypes.Type(value = VehicleRide::class, name = "LogVehicleRide"),
    JsonSubTypes.Type(value = MatchDefinition::class, name = "LogMatchDefinition"),
    JsonSubTypes.Type(value = MatchStart::class, name = "LogMatchStart"),
    JsonSubTypes.Type(value = GameStatePeriodic::class, name = "LogGameStatePeriodic"),
    JsonSubTypes.Type(value = VehicleLeave::class, name = "LogVehicleLeave"),
    JsonSubTypes.Type(value = PlayerTakeDamage::class, name = "LogPlayerTakeDamage"),
    JsonSubTypes.Type(value = PlayerLogout::class, name = "LogPlayerLogout"),
    JsonSubTypes.Type(value = ItemAttach::class, name = "LogItemAttach"),
    JsonSubTypes.Type(value = ItemDrop::class, name = "LogItemDrop"),
    JsonSubTypes.Type(value = PlayerKill::class, name = "LogPlayerKill"),
    JsonSubTypes.Type(value = ItemDetach::class, name = "LogItemDetach"),
    JsonSubTypes.Type(value = ItemUse::class, name = "LogItemUse"),
    JsonSubTypes.Type(value = CarePackageSpawn::class, name = "LogCarePackageSpawn"),
    JsonSubTypes.Type(value = VehicleDestroy::class, name = "LogVehicleDestroy"),
    JsonSubTypes.Type(value = CarePackageLand::class, name = "LogCarePackageLand"),
    JsonSubTypes.Type(value = MatchEnd::class, name = "LogMatchEnd"),
    JsonSubTypes.Type(value = SwimEnd::class, name = "LogSwimEnd"),
    JsonSubTypes.Type(value = SwimStart::class, name = "LogSwimStart"),
    JsonSubTypes.Type(value = PlayerMakeGroggy::class, name = "LogPlayerMakeGroggy"),
    JsonSubTypes.Type(value = ArmorDestroy::class, name = "LogArmorDestroy"),
    JsonSubTypes.Type(value = PlayerRevive::class, name = "LogPlayerRevive"),
    JsonSubTypes.Type(value = WheelDestroy::class, name = "LogWheelDestroy")
)
open class TelemetryEvent {

    @JsonProperty("_D")
    lateinit var timestamp: Instant

    var common: Common? = null

}
