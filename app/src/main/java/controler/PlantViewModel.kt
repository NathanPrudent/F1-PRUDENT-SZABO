package controler

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Plant
import model.plantsRequest
import view.R


class PlantViewModel : ViewModel() {

    private val plantLiveData = MutableLiveData<List<Plant>>()

    fun callPlantsRequest() = viewModelScope.launch{
            val listPlant : List<Plant> = plantsRequest()
            println("Data received")
            plantLiveData.value = listPlant
    }

    fun getPlants(): MutableLiveData<List<Plant>> {
        return plantLiveData
    }

}