package com.openclassrooms.magicgithub.ui.user_list

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User

class ListUserViewHolder(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, listener: UserListAdapter.Listener) {
        Glide.with(binding.root.context)
            .load(user.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_add_black_24dp)
            .error(R.drawable.ic_add_black_24dp)
            .into(binding.itemListUserAvatar)

        binding.itemListUserUsername.text = user.login
        binding.root.setBackgroundColor(if (user.isActive) Color.WHITE else Color.RED)
        binding.itemListUserDeleteButton.setOnClickListener { listener.onClickDelete(user) }
    }
}
