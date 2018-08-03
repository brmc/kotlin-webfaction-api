package pw.mcclure.webfaction.api.oo

data class App(
    var id: Int,
    var name: String,
    var type: String,
    var autostart: Boolean,
    var port: Int,
    var openPort: Boolean,
    var extraInfo: String,
    var machine: String
)

fun App.fromMap(map: HashMap<String, *>) = App(
    map["id"] as Int,
    map["name"] as String,
    map["type"] as String,
    map["autostart"] as Boolean,
    map["port"] as Int,
    map["openPort"] as Boolean,
    map["extraInfo"] as String,
    map["machine"] as String
)

data class AppType(
    var name: String,
    var label: String,
    var description: String,
    // Webfaction returns a string here
    var autostart: String,
    var extraInfo: String,
    var openPort: Boolean
)

fun AppType.fromMap(map: HashMap<String, *>) = AppType(
    map["name"] as String,
    map["label"] as String,
    map["description"] as String,
    map["autostart"] as String,
    map["extra_info"] as String,
    map["open_port"] as Boolean
)