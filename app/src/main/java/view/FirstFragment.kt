package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import model.Contact
import controler.ContactViewModel
import controler.PlantViewModel
import model.Plant


class FirstFragment: Fragment(R.layout.fragment_first) {
    val plantViewModel: PlantViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        plantViewModel.getPlants().observe(this, Observer<List<Plant>>{ listPlants ->
            //recyclerView.adapter = NameAdapter(listPlants)

            val imageView1: ImageView = view.findViewById(R.id.imageView1)
            imageView1.load(listPlants[0].image)
            val textView1: TextView = view.findViewById(R.id.textView1)
            textView1.text = listPlants[0].nom + " : " + listPlants[0].description

            val imageView2: ImageView = view.findViewById(R.id.imageView2)
            imageView2.load(listPlants[1].image)
            val textView2: TextView = view.findViewById(R.id.textView2)
            textView2.text = listPlants[1].nom + " : " + listPlants[1].description

            val imageView3: ImageView = view.findViewById(R.id.imageView3)
            imageView3.load(listPlants[2].image)
            val textView3: TextView = view.findViewById(R.id.textView3)
            textView3.text = listPlants[2].nom + " : " + listPlants[2].description
        })


        val buttonRequest: Button = view.findViewById(R.id.buttonRequest)
        buttonRequest.setOnClickListener {
            plantViewModel.callPlantsRequest()
        }

    }
}










