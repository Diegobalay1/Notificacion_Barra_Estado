package com.diego.kotlin.notificacionbarraestado

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    // Identificador único que usaremos para hacer referencia a este canal:
    public val CHANNEL_ID = "channel_id"

    private fun createNotificationChannel() {
        // Crear el canal solo para API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = getString(R.string.channel_description)

            // Registramos el canal en el sistema
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        //createNotificationChannel()

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

            //createNotificationChannel()

            val NOTIF_ID = 1
            val notificationManager = NotificationManagerCompat.from(this@MainActivity)
            notificationManager.notify(NOTIF_ID, builder.build())

            createNotificationChannel()

        }

    }
}