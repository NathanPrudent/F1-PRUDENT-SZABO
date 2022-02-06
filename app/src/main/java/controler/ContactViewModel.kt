package controler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Contact
import model.request


class ContactViewModel : ViewModel() {

    private val contactLiveData = MutableLiveData<List<Contact>>()

    fun contactRequest() = viewModelScope.launch{
            val listContact : List<Contact> = request()
            println("Data get")
            contactLiveData.value = listContact
    }

    fun getContacts(): MutableLiveData<List<Contact>> {
        return contactLiveData
    }
}