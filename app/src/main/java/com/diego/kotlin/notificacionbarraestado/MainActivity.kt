package com.diego.kotlin.notificacionbarraestado

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    public val CHANNEL_ID = "channel_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icono_notificacion)
                .setContentTitle("!Hola mundo!")
                .setContentText("Mi ejemplo de notificación")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val intent = Intent(this@MainActivity, ActividadResultado::class.java)
            val pendingIntent = PendingIntent.getActivity(this@MainActivity, 0, intent,
                                                                PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pendingIntent)

            val NOTIF_ID = 1
            val notificationManager = NotificationManagerCompat.from(this@MainActivity)
            notificationManager.notify(NOTIF_ID, builder.build())

        }

    }
}