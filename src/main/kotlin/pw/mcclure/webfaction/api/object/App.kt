package pw.mcclure.webfaction.api.`object`

/// See [AppApi]
data class App(
    val id: Int,
    val name: String,
    val type: String,
    val autostart: Boolean,
    val port: Int,
    val openPort: Boolean,
    val extraInfo: String,
    val machine: String
)