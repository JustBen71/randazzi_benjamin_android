package fr.nextu.randazzo_benjamin

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "fr.nextu.randazzo_benjamin.action.FOO"
private const val ACTION_BAZ = "fr.nextu.randazzo_benjamin.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "fr.nextu.randazzo_benjamin.extra.PARAM1"
private const val EXTRA_PARAM2 = "fr.nextu.randazzo_benjamin.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class ServiceTest : IntentService("ServiceTest") {

    override fun onHandleIntent(intent: Intent?) {
        /*val url = URL("https://ror-next-u.onrender.com/beers.json")
        val connection = url.openConnection()
        var variable = ""
        // Lecture de la réponse
        val response = connection.inputStream.bufferedReader().use {
            variable = it.readText()
        }
        Log.d("blabla", variable)*/
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url("https://api.betaseries.com/movies/list")
            .get()
            .addHeader("X-BetaSeries-Key", "77b233b849ac")
            .build()

        val response: Response = client.newCall(request).execute()

        Log.d("blabla", response.body?.string() ?: "")
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String?, param2: String?) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String?, param2: String?) {
        TODO("Handle action Baz")
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startAction(context: Context) {
            val intent = Intent(context, ServiceTest::class.java)
            context.startService(intent)
        }
    }
}