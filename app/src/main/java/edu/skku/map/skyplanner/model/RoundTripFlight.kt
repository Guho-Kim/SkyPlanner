package edu.skku.map.skyplanner.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoundTripFlight(
    val flightId: Int,
    val departureDate: String,
    val arrivalDate: String,
    val airlineName: String,
    val ticketPrice: Int,
    val flightTime: Long,
    val departureLocation: String,
    val arrivalLocation: String,
    val returnFlightId: Int,
    val returnDepartureDate: String,
    val returnArrivalDate: String,
    val returnAirlineName: String,
    val returnTicketPrice: Int,
    val returnFlightTime: Long
) : Parcelable
