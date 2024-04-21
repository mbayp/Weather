package com.example.weatherjourney.core.data.implementation

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import com.example.weatherjourney.core.data.NetworkMonitor
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConnectivityManagerNetworkMonitor @Inject constructor(
    @ApplicationContext context: Context,
) : NetworkMonitor {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observe(): Flow<NetworkMonitor.Status> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch { send(NetworkMonitor.Status.Available) }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch { send(NetworkMonitor.Status.Unavailable) }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch { send(NetworkMonitor.Status.Lost) }
                }
            }

            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.map { it.also { Log.d("NetworkCall", it.toString()) } }.distinctUntilChanged()
    }
}
