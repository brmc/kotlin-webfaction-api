package pw.mcclure.webfaction.client

import de.timroes.axmlrpc.XMLRPCClient
import java.net.URL

interface RpcAdapter {
    fun call(method: String, vararg params: Any): Any
}

open class WebfactionRpc : RpcAdapter {
    val client =
        XMLRPCClient(URL("https://api.webfaction.com"))

    override fun call(method: String, vararg params: Any): Any =
        client.call(method, *params)
}

open class ExistingSessionRpc(var sessionId: String) : WebfactionRpc() {
    override fun call(method: String, vararg params: Any): Any {
        return if (method == "login") arrayOf(sessionId)
        else super.call(method, *params)
    }
}