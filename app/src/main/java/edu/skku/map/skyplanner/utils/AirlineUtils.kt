package edu.skku.map.skyplanner.utils

import edu.skku.map.skyplanner.R

object AirlineUtils {

    // 항공사 이름에 따른 로고 리소스를 반환
    fun getAirlineLogoResource(airlineName: String): Int {
        return when (airlineName) {
            "대한항공" -> R.drawable.korean_air_logo
            "진에어항공" -> R.drawable.jin_air_logo
            "티웨이항공" -> R.drawable.tway_air_logo
            "제주항공" -> R.drawable.jeju_air_logo
            "아시아나항공" -> R.drawable.asiana_air_logo
            "에어부산" -> R.drawable.air_busan_logo
            "카타르항공" -> R.drawable.qatar_air_logo
            else -> R.drawable.default_air_logo // 기본 로고 (없을 경우 대체)
        }
    }
    fun getAirportNames(airportName: String): String{
        return when(airportName){
            "ICN" -> "인천국제공항"
            "SYD" -> "시드니공항"
            "JFK" -> "뉴욕존에프케네디공항"
            "DOH" -> "하마드공항"
            else -> ""
        }
    }
}
