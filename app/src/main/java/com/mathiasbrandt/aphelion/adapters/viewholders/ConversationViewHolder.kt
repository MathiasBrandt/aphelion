package com.mathiasbrandt.aphelion.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item_conversation.view.*

class ConversationViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
    val profilePicture = layout.profile_picture
    val participants = layout.participants
    val preview = layout.preview
    val timestamp = layout.timestamp
}