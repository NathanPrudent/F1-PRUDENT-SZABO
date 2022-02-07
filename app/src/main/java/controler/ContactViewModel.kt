package controler

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Contact
import model.contactsRequest
import view.R


class ContactViewModel : ViewModel() {

    private val contactLiveData = MutableLiveData<List<Contact>>()

    fun callContactsRequest() = viewModelScope.launch{
            val listContact : List<Contact> = contactsRequest()
            println("Data received")
            contactLiveData.value = listContact
    }

    fun getContacts(): MutableLiveData<List<Contact>> {
        return contactLiveData
    }

}