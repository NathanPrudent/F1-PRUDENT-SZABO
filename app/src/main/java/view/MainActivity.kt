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
import com.google.android.material.bottomnavigation.BottomNavigationView
import model.Trial


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if(supportFragmentManager.fragments.count() == 0) {
            supportFragmentManager.commit {
                replace(R.id.frame_layout, IntroFragment())
            }
        }

        /*
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.accueil -> {
                    goToIntro(FirstFragment().listTrials)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.list_trial -> {
                    goToListTrial(IntroFragment().listTrial)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        */
    }

    fun goToIntro(listTrials : List<Trial>){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, IntroFragment().apply { arguments = bundleOf("list" to listTrials) })
        }
    }

    fun goToListTrial(listTrials : List<Trial>){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, FirstFragment().apply { arguments = bundleOf("list" to listTrials) })
        }
    }

    fun goToDetail(listTrials : List<Trial>, index: Int){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, SecondFragment().apply { arguments = bundleOf("list" to listTrials, "index" to index) })
        }
    }
}
