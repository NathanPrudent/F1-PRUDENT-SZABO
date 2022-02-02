package view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstFragment: Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact1: model.Contact = model.request(0)
        val contact2: model.Contact = model.request(1)
        val contact3: model.Contact = model.request(2)

        //val initial =
        val list = listOf(contact1.firstName + " " + contact1.lastName,
            contact2.firstName + " " + contact2.lastName,
            contact3.firstName + " " + contact3.lastName)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NameAdapter(list)
    }
}










