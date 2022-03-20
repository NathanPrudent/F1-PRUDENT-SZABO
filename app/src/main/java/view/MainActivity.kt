package view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import model.Trial


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // use the fragment "IntroFragment"
        if(supportFragmentManager.fragments.count() == 0) {
            supportFragmentManager.commit {
                replace(R.id.frame_layout, IntroFragment())
            }
        }
    }

    // change fragment for "IntroFragment" and pass the list of trials in arguments
    fun goToIntro(listTrials : List<Trial>){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, IntroFragment().apply { arguments = bundleOf("list" to listTrials) })
        }
    }

    // change fragment for "FirstFragment" and pass the list of trials in arguments
    fun goToListTrial(listTrials : List<Trial>){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, FirstFragment().apply { arguments = bundleOf("list" to listTrials) })
        }
    }

    // change fragment for "SecondFragment" and pass the list of trials and the index of a trial in arguments
    fun goToDetail(listTrials : List<Trial>, index: Int){
        supportFragmentManager.commit {
            replace(R.id.frame_layout, SecondFragment().apply { arguments = bundleOf("list" to listTrials, "index" to index) })
        }
    }
}
