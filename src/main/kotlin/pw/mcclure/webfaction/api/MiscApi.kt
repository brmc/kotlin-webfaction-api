package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc


/**
 * Execute shell commands, run php scripts, and set Apache ACL
 *
 * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#miscellaneous>
 */
class MiscApi(sessionId: String, rpc: RpcAdapter = WebfactionRpc()) :
    Api(sessionId, rpc) {

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-run_php_script>
     */
    fun runPhpScript(path: String, codeBefore: String) =
        call("run_php_script", path, codeBefore)

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-set_apache_acl>
     */
    fun setApacheAcl(
        paths: List<String>, permission: String, recursive: Boolean
    ) =
        call("set_apache_acl", paths, permission, recursive)

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-system>
     */
    fun system(cmd: String) = call("system", cmd)
}


/**import "dart:async"

import "package:webfaction_api/src/data/misc.dart"

import "api.dart"

fun runPhpScriptFromInstance(PhpScript script) =
runPhpScript(script.path, script.codeBefore)

fun setApacheAclFromInstance(ApacheAcl acl) =
setApacheAcl(acl.paths, acl.permission, acl.recursive)

fun systemFromInstance(Cmd cmd) =system(cmd.cmd)
}
 * */