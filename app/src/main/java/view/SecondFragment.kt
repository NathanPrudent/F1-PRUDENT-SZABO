package view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import controler.TrialViewModel
import model.Trial


class SecondFragment: Fragment(R.layout.fragment_second) {
    val trialViewModel: TrialViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index : Int = arguments!!.getInt("index")

        trialViewModel.callTrialsRequest()

        trialViewModel.getTrials().observe(this, Observer<List<Trial>>{ listTrials ->

            val nameTrial: TextView = view.findViewById(R.id.nameTrial)
            nameTrial.text = listTrials[index].nom

            val imageTrial: ImageView = view.findViewById(R.id.imageTrial)
            imageTrial.load(listTrials[index].image)

            val descTrial: TextView = view.findViewById(R.id.descTrial)
            descTrial.text = "Description : " + listTrials[index].description + "\n" +
                             "Type : " + listTrials[index].type + "\n" +
                             "Jour : " + listTrials[index].jour + "\n"
        })

        val buttonReturn: Button = view.findViewById(R.id.buttonReturn)
        buttonReturn.setOnClickListener {
            (requireActivity() as MainActivity).goToListTrial()
        }

    }
}










