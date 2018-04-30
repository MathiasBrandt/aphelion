package com.mathiasbrandt.aphelion

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

fun millisToDateTime(millis: Long): LocalDateTime {
    return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime()
}