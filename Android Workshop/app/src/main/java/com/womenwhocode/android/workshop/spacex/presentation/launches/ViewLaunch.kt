package com.womenwhocode.android.workshop.spacex.presentation.launches


//Data used in the view
data class ViewLaunch(
        val missionName: String,
        val launchYear: String,
        val launchSuccess: Boolean,
        val details: String?,
        val rocketName: String,
        val siteName: String,
        val image: String,
        val smallImage: String)
