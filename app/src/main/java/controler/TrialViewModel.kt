package controler

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Trial
import model.trialsRequest
import view.R


class TrialViewModel : ViewModel() {

    private val trialLiveData = MutableLiveData<List<Trial>>()

    fun callTrialsRequest() = viewModelScope.launch{
            val listTrial : List<Trial> = trialsRequest()
            println("Data received")
            trialLiveData.value = listTrial
    }

    fun getTrials(): MutableLiveData<List<Trial>> {
        return trialLiveData
    }

}