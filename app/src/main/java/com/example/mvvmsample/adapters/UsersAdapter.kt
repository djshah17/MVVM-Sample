package com.example.mvvmsample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsample.R
import com.example.mvvmsample.models.User

class UsersAdapter(private val context: Context, private var list: MutableList<User>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.user_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list.get(position)
        holder.name?.text = user.name
        holder.info1?.text = user?.userName + " | " + user?.email
        holder.info2?.text = user?.phone + " | " + user?.website
        val addressObj = user.addressObject
        holder.address?.text = addressObj?.suite + "," + addressObj?.street + "," + addressObj?.city + "," + addressObj?.zipCode
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var name: TextView? = null
        var info1: TextView? = null
        var info2: TextView? = null
        var address: TextView? = null

        init {
            name = view.findViewById(R.id.txt_user_name)
            info1 = view.findViewById(R.id.txt_user_info1)
            info2 = view.findViewById(R.id.txt_user_info2)
            address = view.findViewById(R.id.txt_user_address)
        }

    }

}