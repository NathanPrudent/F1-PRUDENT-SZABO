package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Trial


class FirstFragment: Fragment(R.layout.fragment_first), FirstNameCallBack {

    var listTrials : List<Trial> = listOf<Trial>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listTrials = requireArguments().get("list") as List<Trial> // get the list of trials in arguments

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = NameAdapter(listTrials, this)

        val buttonAccueil: Button = view.findViewById(R.id.buttonAccueil)
        buttonAccueil.setOnClickListener {
            (requireActivity() as MainActivity).goToIntro(listTrials) // display the introduction fragment
        }
    }

    override fun onNameClicked(indexTrial: Int){
        (requireActivity() as MainActivity).goToDetail(listTrials, indexTrial) // display the second fragment
    }
}










