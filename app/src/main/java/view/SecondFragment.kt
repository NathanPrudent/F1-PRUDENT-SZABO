package view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.*
import coil.load
import model.Trial


class SecondFragment: Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index : Int = requireArguments().getInt("index") // get the the index of a trial in the list of trials

        var listTrials = requireArguments().get("list") as List<Trial> // get the list of trials in arguments


        val nameTrial: TextView = view.findViewById(R.id.nameTrial)
        nameTrial.text = listTrials[index].nom

        val imageTrial: ImageView = view.findViewById(R.id.imageTrial)
        imageTrial.load(listTrials[index].image)

        val descTrial: TextView = view.findViewById(R.id.descTrial)
        descTrial.text = "Description : " + listTrials[index].description + "\n" +
                         "Type : " + listTrials[index].type + "\n" +
                         "Jour : " + listTrials[index].jour + "\n"


        val buttonReturn: Button = view.findViewById(R.id.buttonReturn)
        buttonReturn.setOnClickListener {
            (requireActivity() as MainActivity).goToListTrial(listTrials) // display the first fragment
        }

    }
}










