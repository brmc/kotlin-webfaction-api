package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

/**
 *  User management for shell access
 *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#shell-users>
 */
class ShellUserApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-change_user_password>
     */
    fun changePassword(username: String, password: String) =
        call("change_user_password", username, password);

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_user>
     */
    fun create(
        username: String,
        shell: String = "none",
        groups: List<String> = emptyList()
    ) =
        call("create_user", username, shell, groups);

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_user>
     */
    fun delete(username: String) = call("delete_user", username);

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_users>
     */
    fun list() = call("list_users");
}

/*import "dart:async";

import "package:webfaction_api/src/data/shell_user.dart";

import "api.dart";
class ShellUserApi extends Api {
  ShellUserApi(sessionId: String, [Function rpc]) : super(sessionId, rpc);


  fun changePasswordFromInstance(User user, password: String) =
      changePassword(user.username, password);

  fun createFromInstance(User user) =
      create(user.username, user.shell, user.groups);


  fun deleteFromInstance(User user) = delete(user.username);
}

**/