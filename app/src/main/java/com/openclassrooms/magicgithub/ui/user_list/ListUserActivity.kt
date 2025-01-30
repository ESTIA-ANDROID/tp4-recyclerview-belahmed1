package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    private lateinit var binding: ActivityListUserBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater).apply { setContentView(root) }

        setupFabClick()
        initializeRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        refreshUserList()
    }

    private fun initializeRecyclerView() {
        adapter = UserListAdapter(this).also { binding.activityListUserRv.adapter = it }
        setupSwipeGesture()
        setupDragAndDrop()
    }

    private fun setupFabClick() {
        binding.activityListUserFab.setOnClickListener {
            getRepository().addRandomUser()
            refreshUserList()
        }
    }

    private fun refreshUserList() {
        adapter.updateList(getRepository().getUsers())
    }

    override fun onClickDelete(user: User) {
        Log.d(TAG, "User attempts to delete an item.")
        getRepository().deleteUser(user)
        refreshUserList()
    }

    private fun setupSwipeGesture() {
        val swipeCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val user = adapter.getUsers()[viewHolder.adapterPosition].apply { isActive = !isActive }
                adapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }
        ItemTouchHelper(swipeCallback).attachToRecyclerView(binding.activityListUserRv)
    }

    private fun setupDragAndDrop() {
        val dragCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.swapItems(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        }
        ItemTouchHelper(dragCallback).attachToRecyclerView(binding.activityListUserRv)
    }

    companion object {
        private val TAG = ListUserActivity::class.java.simpleName
    }
}
