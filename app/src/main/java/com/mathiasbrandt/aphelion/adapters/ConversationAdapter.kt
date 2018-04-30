package com.mathiasbrandt.aphelion.adapters

import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.adapters.listeners.ConversationItemListener
import com.mathiasbrandt.aphelion.adapters.viewholders.ConversationViewHolder
import com.mathiasbrandt.aphelion.models.Conversation

class ConversationAdapter(val items: List<Conversation>, val listener: ConversationItemListener) : RecyclerView.Adapter<ConversationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        var layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_conversation, parent, false)
        val viewholder = ConversationViewHolder(layout)

        layout.setOnClickListener({
            listener.onConversationSelected(viewholder.conversationId)
        })

        return viewholder
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        var conversation =  items.get(position)

        holder.conversationId = conversation.id
        holder.participants.text = conversation.participants
        holder.preview.text = conversation.preview

//        val time = millisToDateTime(conversation.timestamp)
        val time = DateUtils.getRelativeTimeSpanString(conversation.timestamp, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS)
        holder.timestamp.text = time
    }

    override fun getItemCount(): Int {
        return items.size
    }
}