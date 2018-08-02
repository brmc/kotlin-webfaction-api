package pw.mcclure.webfaction.client

import pw.mcclure.webfaction.api.*


/**
 * The main entry point for using the Webfaction API
 *
 * Created from your Webfaction [username], [password], and [server]
 * information. Optionally the [rpc] mechanism can be swapped out with the
 * implementation of your choosing
 */
open class Client(
    internal val username: String,
    internal val password: String,
    internal val serverName: String,
    internal val rpc: RpcAdapter = WebfactionRpc()
) : RpcAdapter by rpc {

    var sessionId = ""
        set(value) {
            field = value
            app = AppApi(sessionId, rpc)
            certificate = CertificateApi(sessionId, rpc)
            cron = CronApi(sessionId, rpc)
            db = DbApi(sessionId, rpc)
            dns = DnsApi(sessionId, rpc)
            domain = DomainApi(sessionId, rpc)
            email = EmailApi(sessionId, rpc)
            file = FileApi(sessionId, rpc)
            general = GeneralApi(sessionId, rpc)
            server = ServerApi(sessionId, rpc)
            shellUser = ShellUserApi(sessionId, rpc)
            website = WebsiteApi(sessionId, rpc)
            misc = MiscApi(sessionId, rpc)
        }

    val app: AppApi = AppApi(rpc)
    val misc: MiscApi = MiscApi(rpc)
    val certificate: CertificateApi = CertificateApi(rpc)
    val cron: CronApi = CronApi(rpc)
    val db: DbApi = DbApi(rpc)
    val dns: DnsApi = DnsApi(rpc)
    val domain: DomainApi = DomainApi(rpc)
    val email: EmailApi = EmailApi(rpc)
    val file: FileApi = FileApi(rpc)
    val general: GeneralApi = GeneralApi(rpc)
    val server: ServerApi = ServerApi(rpc)
    val shellUser: ShellUserApi = ShellUserApi(rpc)
    val website: WebsiteApi = WebsiteApi(rpc)

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


