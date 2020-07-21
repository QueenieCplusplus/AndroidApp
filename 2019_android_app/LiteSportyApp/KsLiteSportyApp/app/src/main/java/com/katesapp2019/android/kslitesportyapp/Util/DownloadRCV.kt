package com.katesapp2019.android.kslitesportyapp.Util

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.katesapp2019.android.kslitesportyapp.Base.BasePreference
import java.io.File

class DownloadRCV (var context: Context): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

    }

    private fun seekAPK(context: Context): File? {
        var kAPK: File? = null
        val dM = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val cacheDownloadID = BasePreference.getLong(context, "download ID", -1)

        if (cacheDownloadID != -1L) {
            val query = DownloadManager.Query()
            query.setFilterById(cacheDownloadID)
            query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL)
        }
    }

}