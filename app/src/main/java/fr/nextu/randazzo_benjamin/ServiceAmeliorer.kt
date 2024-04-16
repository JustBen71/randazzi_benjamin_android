package fr.nextu.randazzo_benjamin

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.Build
import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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
class ServiceAmeliorer : IntentService("ServiceAmeliorer") {

    override fun onHandleIntent(intent: Intent?) {
        val url = URL("https://ror-next-u.onrender.com/beers.json")
        val connection = url.openConnection()
        var variable = ""
        // Lecture de la réponse
        val response = connection.inputStream.bufferedReader().use {
            variable = it.readText()
        }
        Log.d("blabla", variable)
    }

    fun requestMoviesList() = CoroutineScope(Dispatchers.IO).async {
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url("https://api.betaseries.com/movies/list")
            .get()
            .addHeader("X-BetaSeries-Key", "77b233b849ac")
            .build()

        val response: Response = client.newCall(request).execute()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            //notifyNewData(response)
        }
        //moviesFromJson(response.body?.string() ?: "")
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
            val intent = Intent(context, ServiceAmeliorer::class.java)
            context.startService(intent)
        }
    }
}