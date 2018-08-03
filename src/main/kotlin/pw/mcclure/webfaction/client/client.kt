package pw.mcclure.webfaction.client

import pw.mcclure.webfaction.api.simple.*
import kotlin.reflect.KProperty


/**
 * The main entry point for using the Webfaction API
 *
 * Created from your Webfaction [username], [password], and [serverName]
 * information. Optionally the [rpc] mechanism can be swapped out with the
 * implementation of your choosing
 */
open class Client(
    internal val username: String,
    internal val password: String,
    internal val serverName: String,
    internal val rpc: RpcAdapter = WebfactionRpc()
) : RpcAdapter by rpc {

    var sessionId: String by SessionUpdater()

    val app: AppApi =
        AppApi(rpc)
    val misc: MiscApi =
        MiscApi(rpc)
    val certificate: CertificateApi =
        CertificateApi(rpc)
    val cron: CronApi =
        CronApi(rpc)
    val db: DbApi =
        DbApi(rpc)
    val dns: DnsApi =
        DnsApi(rpc)
    val domain: DomainApi =
        DomainApi(rpc)
    val email: EmailApi =
        EmailApi(rpc)
    val file: FileApi =
        FileApi(rpc)
    val general: GeneralApi =
        GeneralApi(rpc)
    val server: ServerApi =
        ServerApi(rpc)
    val shellUser: ShellUserApi =
        ShellUserApi(rpc)
    val website: WebsiteApi =
        WebsiteApi(rpc)

    /**
     * Logs in to the Webfaction API
     *
     * Upon successful login, the [sessionId] will be available and the
     * underlying API classes will be instantiated.
     */
    fun login() = call("login", username, password, serverName, 2)
        .let { it as Array<*> }
        .also { sessionId = it[0] as String }
}

/**
 * Changes to [Client.sessionId] are propagated to API objects
 */
private class SessionUpdater {
    operator fun getValue(client: Client, property: KProperty<*>): String {
        return client.sessionId
    }

    operator fun setValue(
        client: Client, prop: KProperty<*>, sessionId: String
    ) {
        client.sessionId = sessionId
        client.app.sessionId = sessionId
        client.misc.sessionId = sessionId
        client.certificate.sessionId = sessionId
        client.cron.sessionId = sessionId
        client.db.sessionId = sessionId
        client.dns.sessionId = sessionId
        client.domain.sessionId = sessionId
        client.email.sessionId = sessionId
        client.file.sessionId = sessionId
        client.general.sessionId = sessionId
        client.server.sessionId = sessionId
        client.shellUser.sessionId = sessionId
        client.website.sessionId = sessionId
    }
}