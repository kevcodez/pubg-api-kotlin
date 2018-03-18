package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
enum class Region(val identifier: String) {

    XBOX_ASIA("xbox-as"),
    XBOX_EU("xbox-as"),
    XBOX_NA("xbox-as"),
    XBOX_OC("xbox-as"),
    PC_KOREA_JAPAN("xbox-as"),
    PC_NA("xbox-as"),
    PC_EU("xbox-as"),
    PC_OC("xbox-as"),
    PC_KAKAO("xbox-as"),
    PC_SEA("xbox-as"),
    PC_SA("xbox-as"),
    PC_ASIA("xbox-as")

}