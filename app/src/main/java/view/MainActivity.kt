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
import androidx.core.os.bundleOf
import java.io.InputStreamReader
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        goToListTrial()
    }

    fun goToDetail(index: Int){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, SecondFragment().apply { arguments = bundleOf("index" to index) })
        }
    }

    fun goToListTrial(){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, FirstFragment())
        }
    }
}
