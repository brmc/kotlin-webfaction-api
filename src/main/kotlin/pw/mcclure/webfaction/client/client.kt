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

    var app: AppApi? = null
        protected set

    lateinit var certificate: CertificateApi
    lateinit var misc: MiscApi
    lateinit var cron: CronApi
    lateinit var db: DbApi
    lateinit var dns: DnsApi
    lateinit var domain: DomainApi
    lateinit var email: EmailApi
    lateinit var file: FileApi
    lateinit var general: GeneralApi
    lateinit var server: ServerApi
    lateinit var shellUser: ShellUserApi
    lateinit var website: WebsiteApi

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


