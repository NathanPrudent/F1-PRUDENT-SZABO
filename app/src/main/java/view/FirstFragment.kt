package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import controler.TrialViewModel
import model.Trial
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class FirstFragment: Fragment(R.layout.fragment_first), FirstNameCallBack {
    val trialViewModel: TrialViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        trialViewModel.getTrials().observe(this, Observer<List<Trial>>{ listTrials ->
            recyclerView.adapter = NameAdapter(listTrials, this)
        })


        val buttonRequest: Button = view.findViewById(R.id.buttonRequest)
        buttonRequest.setOnClickListener {
            trialViewModel.callTrialsRequest()
            buttonRequest.setVisibility(View.INVISIBLE);
        }

    }

    override fun onNameClicked(indexTrial: Int){
        (requireActivity() as MainActivity).goToDetail(indexTrial)
    }
}










