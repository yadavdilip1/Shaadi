package com.example.shaadi.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.shaadi.R
import com.example.shaadi.data.entities.UserResult
import com.example.shaadi.databinding.ItemUserRowBinding
import com.example.shaadi.ui.recyclinterface.UserItemActionListener
import com.example.shaadi.utils.UserUtils
import com.example.shaadi.utils.loadImage

class UserAdapter(private val listener: UserItemActionListener) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val items = ArrayList<UserResult>()

    fun setItems(items: ArrayList<UserResult>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ItemUserRowBinding =
            ItemUserRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(items[position])

    inner class UserViewHolder(
        private val itemBinding: ItemUserRowBinding,
        private val listener: UserItemActionListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private lateinit var data: UserResult

        @SuppressLint("SetTextI18n")
        fun bind(item: UserResult) {

            this.data = item

            itemBinding.apply {

                tvName.text = UserUtils.getPersonName(item)

                tvAddress.text = UserUtils.getPersonLocation(item)

                tvConnected.isVisible = item.connection.isUpdated

                tvAccept.isVisible = !item.connection.isUpdated
                tvDecline.isVisible = !item.connection.isUpdated
                tvConnected.text = UserUtils.getUpdatedStatus(item)

                tvAccept.setOnClickListener {

                    listener.onAcceptButtonClick(item)
                }

                tvDecline.setOnClickListener {

                    listener.onIgnoreButtonClick(item)
                }

                ivProfile.loadImage(
                    root.context,
                    item.picture.large,
                    R.color.placeholder_color
                )

            }


        }


    }


}

