package com.androidi.fos.materialdesigner

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.IOException
import java.net.URL


class DownloadImageTask(private val imageView: ImageView) : AsyncTask<String, Void, Bitmap>() {
    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = params[0]
        var bitmap: Bitmap? = null

        try {
            val inputStream = URL(url).openStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            Log.d("Erro: ", e.message)
        }

        return bitmap
    }


    override fun onPostExecute(bitmap: Bitmap) {
        imageView.setImageBitmap(bitmap)
    }
}