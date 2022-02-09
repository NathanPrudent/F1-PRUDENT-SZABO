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
import controler.PlantViewModel
import model.Plant


class SecondFragment: Fragment(R.layout.fragment_second) {
    val plantViewModel: PlantViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index : Int = arguments!!.getInt("index")

        plantViewModel.callPlantsRequest()

        plantViewModel.getPlants().observe(this, Observer<List<Plant>>{ listPlants ->

            val namePlant: TextView = view.findViewById(R.id.namePlant)
            namePlant.text = listPlants[index].nom

            val imagePlant: ImageView = view.findViewById(R.id.imagePlant)
            imagePlant.load(listPlants[index].image)

            val descPlant: TextView = view.findViewById(R.id.descPlant)
            descPlant.text = "Description : " + listPlants[index].description + "\n" +
                             "Type : " + listPlants[index].type + "\n" +
                             "Croissance : " + listPlants[index].croissance + "\n" +
                             "Consommation : " + listPlants[index].consommation + "\n"
        })

        val buttonReturn: Button = view.findViewById(R.id.buttonReturn)
        buttonReturn.setOnClickListener {
            (requireActivity() as MainActivity).goToListPlant()
        }

    }
}










