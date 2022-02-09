package view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import model.Contact
import model.Plant


class NameAdapter(val nameList: List<Plant>) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.cell, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(cellule: Cellule, position: Int) {
        cellule.textView.text = nameList[position].nom + " :\n" + nameList[position].description
        cellule.imageView.load(nameList[position].image)

        cellule.buttonDetail.setOnClickListener {
            println("Button detail click")
        }
    }

    override fun getItemCount(): Int {
        return nameList.count()
    }
}

class Cellule(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.textView) as TextView
    val imageView: ImageView = view.findViewById(R.id.imageView) as ImageView
    val buttonDetail: Button = view.findViewById(R.id.buttonDetail) as Button
}