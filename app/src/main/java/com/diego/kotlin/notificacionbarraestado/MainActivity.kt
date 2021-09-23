package com.diego.kotlin.notificacionbarraestado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

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

        }

    }
}