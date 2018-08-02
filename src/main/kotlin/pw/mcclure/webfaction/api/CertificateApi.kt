package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

open class CertificateApi(
    rpc: RpcAdapter = WebfactionRpc(),
    sessionId: String = ""
) : Api(rpc, sessionId) {

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_certificate>
     */
    fun create(
        name: String,
        certificate: String,
        privateKey: String,
        intermediates: String = ""
    ) = call(
        "create_certificate",
        name,
        certificate,
        privateKey,
        intermediates
    )

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_certificate>
     */
    fun delete(name: String) = call("delete_certificate", name)

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_certificates>
     */
    fun list() = call("list_certificates")

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-update_certificate>
     */
    fun update(
        name: String, cert: String, privateKey: String, intermediates: String
    ) =
        call("update_certificate", name, cert, privateKey, intermediates)
}

/**
 * class CertificateApi extends Api {
CertificateApi(String sessionId, [Function rpc]) : super(sessionId, rpc)


/// Delegates to [create]
Future createFromInstance(Certificate cert) =>
create(cert.name, cert.certificate, cert.privateKey, cert.intermediates)

/// Delegates to [delete]
Future deleteFromInstance(Certificate cert) => delete(cert.name)

/// Delegates to [update]
Future updateFromInstance(Certificate cert) =>
update(cert.name, cert.certificate, cert.privateKey, cert.intermediates)

 */