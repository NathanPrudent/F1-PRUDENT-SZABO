package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
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
            recyclerView.adapter = NameAdapter(listPlants)
        })

        val buttonRequest: Button = view.findViewById(R.id.buttonRequest)

        buttonRequest.setOnClickListener {
            plantViewModel.callPlantsRequest()

            //val imageView: ImageView = view.findViewById(R.id.imageView)
            //imageView.load("https://i.imgur.com/h5Grl0c.jpg")

        }
    }
}










