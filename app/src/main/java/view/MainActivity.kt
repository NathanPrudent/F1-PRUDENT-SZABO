package view

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import java.io.InputStreamReader
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frameLayout = FrameLayout(this).apply {
            id = 0x123
        }
        setContentView(frameLayout)

        if(supportFragmentManager.fragments.count() == 0) {
            supportFragmentManager.commit {
                replace(0x123, FirstFragment())
            }
        }

        /*
        val textView: TextView = findViewById(R.id.textView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        button1.setOnClickListener {
            val contact: model.Contact = model.request(0)

            println("First name: '${contact.firstName}', last name: '${contact.lastName}', num: '${contact.numero}")

            textView.text = contact.firstName
        }

        button2.setOnClickListener {
            val contact: model.Contact = model.request(1)

            println("First name: '${contact.firstName}', last name: '${contact.lastName}', num: '${contact.numero}")

            textView.text = contact.firstName
        }

        button3.setOnClickListener {
            val contact: model.Contact = model.request(2)

            println("First name: '${contact.firstName}', last name: '${contact.lastName}', num: '${contact.numero}")

            textView.text = contact.firstName
        }
        */
        
    }

}
