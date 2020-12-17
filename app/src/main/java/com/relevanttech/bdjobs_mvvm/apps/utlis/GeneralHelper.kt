package com.relevanttech.bdjobs_mvvm.apps.utlis

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.net.UnknownHostException
import java.nio.channels.IllegalBlockingModeException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Bismillah Hir Rahman Nir Raheem
 */
object GeneralHelper {
    fun isNetConnected(context: Context?): Boolean {
        if (context == null)
            return false
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        @SuppressLint("MissingPermission")
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    fun isConnectedToInternet(context: Context, host: String): Boolean {
        var isAvailable = false
        if (isNetConnected(context)) {
            try {

                if (isHostAvailable(host)) {
                    isAvailable = true
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return isAvailable
    }


    /**
     * Checks if the host is available
     * @param hostName The name of the host
     * @return @code{true} if the host is available
     * @throws IOException If it happens
     */
    @Throws(
        IOException::class,
        IllegalBlockingModeException::class,
        IllegalArgumentException::class
    )
    fun isHostAvailable(hostName: String): Boolean {
        var isHostAvailable: Boolean
        isHostAvailable = false
        try {
            Socket().use { socket ->
                val port = 80
                val socketAddress = InetSocketAddress(hostName, port)
                socket.connect(socketAddress, 3000)
                isHostAvailable = true
            }
        } catch (unknownHost: UnknownHostException) {
            isHostAvailable = false
        }
        return isHostAvailable
    }


    fun formateDateFromstring(
        inputFormat: String,
        outputFormat: String,
        inputDate: String
    ): String {
        var parsed: Date? = null
        var outputDate = ""
        val df_input = SimpleDateFormat(inputFormat, Locale.getDefault())
        val df_output = SimpleDateFormat(outputFormat, Locale.getDefault())
        try {
            parsed = df_input.parse(inputDate)
            outputDate = df_output.format(parsed)
        } catch (e: ParseException) {
            Log.d("formattedDateFromString", "ParseException - dateFormat")
        }

        //  return SimpleDateFormat.getDateInstance(DateFormat.LONG).format(parsed)

        return outputDate
    }
}
