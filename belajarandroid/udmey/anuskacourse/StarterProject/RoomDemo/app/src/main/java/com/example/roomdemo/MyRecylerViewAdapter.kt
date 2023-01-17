package com.example.roomdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.databinding.ListMenuBinding
import com.example.roomdemo.db.Subscriber
import com.example.roomdemo.generated.callback.OnClickListener

class MyRecylerViewAdapter(private val clickListener:(Subscriber)->Unit):
    RecyclerView.Adapter<MyViewHolder>() {

    // advance reycile view (jika tidak val ini ditahuruh di dalam class dengan list
    // fungsi dari ini menambahkan performa dari reyclerView rujuk program = speed
    private val subscriberList = ArrayList<Subscriber>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding : ListMenuBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_menu,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return subscriberList.size
    }

    // untuk arrayList dari subscriberList
    // speed
    fun setList(subscriber: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(subscriber)
    }



}

class MyViewHolder(val binding: ListMenuBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber,clickListener:(Subscriber)->Unit) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener{
            clickListener(subscriber)
        }
    }

}