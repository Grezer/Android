package rest

data class listOfCountry(
    val id: Integer,
    val name: String
)

data class CountryDaysChart (
    val date: String,
    val confirmed: Integer,
    val recovered: Integer,
    val critical: Integer,
    val deaths: Integer
)

data class bodyData(
    val id: Integer
)