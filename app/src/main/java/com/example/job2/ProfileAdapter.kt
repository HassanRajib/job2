package com.example.job2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter :ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallBack()) {

    private var onItemClickListener: ((UserProfile) -> Unit)? = null
    private var onDeleteClickListener: ((UserProfile) -> Unit)? = null
    private var onUpdateClickListener: ((UserProfile) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ProfileViewHolder,
        position: Int,
    ) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    fun setOnItemClickListener(listener: (UserProfile) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener: (UserProfile) -> Unit) {
        onDeleteClickListener = listener
    }

    fun setOnUpdateClickListener(listener: (UserProfile) -> Unit) {
        onUpdateClickListener = listener
    }

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val uname: TextView = itemView.findViewById(R.id.naMtxt)
        private val uemail: TextView = itemView.findViewById(R.id.emaiLtxt)
        private val udob: TextView = itemView.findViewById(R.id.doBtxt)
        private val udistrict: TextView = itemView.findViewById(R.id.diStxt)
        private val umobile: TextView = itemView.findViewById(R.id.moBtxt)
        private val deletbTn: ImageButton = itemView.findViewById(R.id.deleBtn)
        private val editbTn: ImageButton = itemView.findViewById(R.id.editBtn)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)
                }
            }
            deletbTn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }
            }
            editbTn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onUpdateClickListener?.invoke(profile)
                }
            }
        }

        fun bind(userProfile: UserProfile) {
            uname.text = userProfile.name
            uemail.text = userProfile.email
            udob.text = userProfile.dob
            udistrict.text = userProfile.district
            umobile.text = userProfile.mobile
        }
    }
        class DiffCallBack : DiffUtil.ItemCallback<UserProfile>() {
            override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
                return oldItem == newItem
            }
        }
}


