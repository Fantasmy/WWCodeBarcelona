package com.womenwhocode.spacex.data.datasources

import com.womenwhocode.spacex.data.model.LaunchDataApi
import com.womenwhocode.spacex.data.model.RocketDataApi
import com.womenwhocode.spacex.data.model.SiteDataApi
import com.womenwhocode.spacex.domain.model.Launch
import com.womenwhocode.spacex.domain.model.Rocket
import com.womenwhocode.spacex.domain.model.Site

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
fun toDomain(source: LaunchDataApi): Launch = with(source) {
    Launch(this.flightNumber,
            this.missionName,
            this.launchYear,
            this.launchDateUnix,
            this.launchSuccess,
            this.details,
            toDomain(this.rocket),
            toDomain(this.site),
            this.links.missionPath,
            this.links.missionPathSmall)
}

fun toDomain(source: RocketDataApi): Rocket = with(source) {
    Rocket(this.id, this.name, this.type)
}

fun toDomain(source: SiteDataApi): Site = with(source) {
    Site(this.id, this.name, this.nameLong)
}