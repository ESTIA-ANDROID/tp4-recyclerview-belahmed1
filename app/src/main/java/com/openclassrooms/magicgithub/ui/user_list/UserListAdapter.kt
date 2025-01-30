package com.openclassrooms.magicgithub.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback

class UserListAdapter(private val listener: Listener) : RecyclerView.Adapter<ListUserViewHolder>() {

    private var userList: MutableList<User> = mutableListOf()

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(userList[position], listener)
    }

    override fun getItemCount(): Int = userList.size

    fun updateList(newUsers: List<User>) {
        val diffCallback = UserDiffCallback(newUsers, userList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        userList = newUsers.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

    fun getUsers(): List<User> = userList

    fun swapItems(fromIndex: Int, toIndex: Int) {
        userList[fromIndex] = userList[toIndex].also { userList[toIndex] = userList[fromIndex] }
        notifyItemMoved(fromIndex, toIndex)
    }
}
