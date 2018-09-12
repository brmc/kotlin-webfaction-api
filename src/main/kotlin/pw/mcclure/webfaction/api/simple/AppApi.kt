package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

open class AppApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_app>
     *
     * Application [type]s can be found with the [listTypes] method
     */
    fun create(
        name: String,
        type: String,
        autostart: Boolean = false,
        extraInfo: String = "",
        openPort: Boolean = false
    ) = call("create_app", name, type, autostart, extraInfo, openPort)
            as HashMap<*, *>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_app>
     */
    fun delete(name: String) = call("delete_app", name) as Array<*>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_apps>
     */
    fun list() = call("list_apps") as Array<*>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_app_types>
     */
    fun listTypes() = call("list_app_types") as Array<*>
}
