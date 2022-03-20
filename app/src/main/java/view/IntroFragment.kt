package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import controler.TrialViewModel
import model.Trial


class IntroFragment: Fragment(R.layout.fragment_intro) {

    val trialViewModel: TrialViewModel by viewModels()

    var listTrial : List<Trial> = listOf<Trial>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // test if there is the list of trials in argument
        if(arguments == null)
        {
            // test if network data are already retrieve
            if(trialViewModel.getTrials().value.isNullOrEmpty())
            {
                trialViewModel.callTrialsRequest() // get the network data
            }
            else
            {
                listTrial = trialViewModel.getTrials().value!! // get data store in the ViewModel
            }
        }
        else
        {
            listTrial = requireArguments().get("list") as List<Trial> // get the list of trials in arguments
        }


        trialViewModel.getTrials().observe(this, Observer<List<Trial>>{ listTrials ->
            listTrial = listTrials
        })


        val titre: TextView = view.findViewById(R.id.titre)
        titre.text = "Décathlon"

        val presentation: TextView = view.findViewById(R.id.presentation)
        presentation.text = "Le décathlon se compose de 10 épreuves sur 2 jours.\n\n" +
                            "Il y a 4 courses, 3 sauts et 3 lancers.\n\n" +
                            "On commence et finit toujours la journée par une course, et on alterne avec saut-lancer-saut ou lancer-saut-lancer.\n\n\n" +
                            "Venez découvrir ce sport avec nous!"

        val buttonRequest: Button = view.findViewById(R.id.buttonRequest)
        buttonRequest.setOnClickListener {
            (requireActivity() as MainActivity).goToListTrial(listTrial) // display the fragment with the list of trials
        }

    }

}










