package view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.Contact


class NameAdapter(val nameList: List<Contact>) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.cell, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(cellule: Cellule, position: Int) {
        cellule.textView.text = nameList[position].firstName + "  " + nameList[position].lastName
    }

    override fun getItemCount(): Int {
        return nameList.count()
    }
}

class Cellule(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view as TextView
}