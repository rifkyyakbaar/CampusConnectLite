package com.example.campusconnectlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    private val eventList: ArrayList<EventModel>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvEventName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvEventLocation)
        val btnDelete: TextView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = eventList[position]
        holder.tvName.text = currentEvent.name
        holder.tvLocation.text = currentEvent.location

        holder.btnDelete.setOnClickListener {
            onDeleteClick(currentEvent.id)
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}