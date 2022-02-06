package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Contact
import controler.ContactViewModel


class FirstFragment: Fragment(R.layout.fragment_first) {
    val contactViewModel: ContactViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        contactViewModel.getContacts().observe(this, Observer<List<Contact>>{ listContact ->
            recyclerView.adapter = NameAdapter(listContact)
        })

        val buttonRequest: Button = view.findViewById(R.id.buttonRequest)

        buttonRequest.setOnClickListener {
            contactViewModel.contactRequest()
        }
    }
}










