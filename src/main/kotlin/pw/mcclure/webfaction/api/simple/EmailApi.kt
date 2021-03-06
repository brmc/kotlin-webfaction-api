package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

class EmailApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {

    fun changePassword(mailboxName: String, password: String) =
        call("change_mailbox_password", mailboxName, password)

    fun create(
        mailboxName: String,
        enableSpamProtection: Boolean = true,
        discardSpam: Boolean = false,
        spamRedirectFolder: String = "",
        useManualProcmailrc: Boolean = false,
        manualProcmailrc: String = ""
    ) =
        call(
            "create_mailbox",
            mailboxName,
            enableSpamProtection,
            discardSpam,
            spamRedirectFolder,
            useManualProcmailrc,
            manualProcmailrc
        )

    fun delete(mailboxName: String) = call("delete_mailbox", mailboxName);

    fun list() = call("list_mailboxes");

    fun update(
        mailboxName: String,
        enableSpamProtection: Boolean = true,
        discardSpam: Boolean = false,
        spamRedirectFolder: String = "",
        useManualProcmailrc: Boolean = false,
        manualProcmailrc: String = ""
    ) =
        call(
            "update_mailbox",
            mailboxName,
            enableSpamProtection,
            discardSpam,
            spamRedirectFolder,
            useManualProcmailrc,
            manualProcmailrc
        )
}
/**import 'dart:async';

import 'package:webfaction_api/src/api/api.dart';
import 'package:webfaction_api/src/data/email.dart';

/// CRUD and password management operations for mailboxes
class MailboxApi extends Api {
MailboxApi(String sessionId, [Function rpc]) : super(sessionId, rpc);

changePasswordFromInstance(Mailbox mailbox, String password) =>
changePassword(mailbox.name, password);

createFromInstance(Mailbox mailbox) => create(
mailbox.name,
mailbox.enableSpamProtection,
mailbox.discardSpam,
mailbox.spamRedirectFolder,
mailbox.useManualProcmailrc,
mailbox.manualProcmailrc,
);


deleteFromInstance(Mailbox mailbox) => delete(mailbox.name);
updateFromInstance(Mailbox mailbox) => update(
mailbox.name,
mailbox.enableSpamProtection,
mailbox.d   iscardSpam,
mailbox.spamRedirectFolder,
mailbox.useManualProcmailrc,
mailbox.manualProcmailrc,
);
}

/// CRUD operations for email addresses
///
/// See [https://docs.webfaction.com/xmlrpc-api/apiref.html#addresses](https://docs.webfaction.com/xmlrpc-api/apiref.html#addresses)
class EmailAddressApi extends Api {
EmailAddressApi(String sessionId, [Function rpc]) : super(sessionId, rpc);

/// See [https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_email](https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_email)
Future create(String address, String targets,
[bool autoresponderOn = false,
String autoresponderSubject = '',
String autoresponderMessage = '',
String autoresponderFrom = '',
String scriptMachine = '',
String scriptPath = '']) =>
call('create_email', [
address,
targets,
autoresponderOn,
autoresponderSubject,
autoresponderMessage,
autoresponderFrom,
scriptMachine,
scriptPath
]);

Future createFromInstance(Email email) => create(
email.address,
email.targets,
email.autoresponderOn,
email.autoresponderSubject,
email.autoresponderMessage,
email.autoresponderFrom,
email.scriptMachine,
email.scriptPath,
);

/// See [https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_email](https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_email)
delete(String address) => call('delete_email', [address]);

deleteFromInstance(Email email) => delete(email.address);

/// See [https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_emails](https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_emails)
Future list() => call('list_emails');

/// See [https://docs.webfaction.com/xmlrpc-api/apiref.html#method-update_email](https://docs.webfaction.com/xmlrpc-api/apiref.html#method-update_email)
Future update(String address, List<String> targets,
[bool autoresponderOn = false,
String autoresponderSubject = '',
String autoresponderMessage = '',
String autoresponderFrom = '',
String scriptMachine = '',
String scriptPath = '']) =>
call('update_email', [
address,
targets,
autoresponderOn,
autoresponderSubject,
autoresponderMessage,
autoresponderFrom,
scriptMachine,
scriptPath
]);

Future updateFromInstance(Email email) => update(
email.address,
email.targets.split(','),
email.autoresponderOn,
email.autoresponderSubject,
email.autoresponderMessage,
email.autoresponderFrom,
email.scriptMachine,
email.scriptPath,
);
}
 */