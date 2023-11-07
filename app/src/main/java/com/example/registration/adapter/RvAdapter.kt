package com.example.registration.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.databinding.ItemRvBinding
import com.example.registration.models.User
import com.squareup.picasso.Picasso


class RvAdapter(var list:ArrayList<User> = ArrayList()): RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User) {
            itemRv.txtName.text = user.displayName
            Picasso.get().load(user.photoLink).into(itemRv.imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}