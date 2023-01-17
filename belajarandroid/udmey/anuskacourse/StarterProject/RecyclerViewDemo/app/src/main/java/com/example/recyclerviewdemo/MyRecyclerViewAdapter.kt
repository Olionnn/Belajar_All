package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val namaorang: List<Siswa>, private val clickListener:(Siswa)->Unit) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val siswa = namaorang[position]
        holder.bind(siswa, clickListener)
//        holder.myTextView.text = siswa.kelas.toString()

    }

    override fun getItemCount(): Int {
        return namaorang.size
    }
}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(siswa: Siswa, clickListener: (Siswa) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        val textkelas = view.findViewById<TextView>(R.id.tvKelas)
        myTextView.text = siswa.name
        textkelas.text = siswa.kelas.toString()

        //toast biasa
        view.setOnClickListener {
            //clik lisner class dibuat orivate buar aman
            clickListener(siswa)
            //toast biasa
//            Toast.makeText(
//                view.context,
//                "Nama : ${siswa.name}, Kelas : ${siswa.kelas}",
//                Toast.LENGTH_LONG
//            ).show()
        }
    }

}