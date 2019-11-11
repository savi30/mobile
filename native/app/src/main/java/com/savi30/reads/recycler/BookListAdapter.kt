package com.savi30.reads.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.savi30.reads.R
import com.savi30.reads.data.Book


class BookListAdapter(
    private val data: List<Book>,
    private val onClickListener: ListItemOnClickListener
) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    interface ListItemOnClickListener {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val itemNumber: TextView = view.findViewById(R.id.tv_item_number)
        val itemName: TextView = view.findViewById(R.id.tv_item_name)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            onClickListener.onClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_view, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemName.text = data[position].name
        viewHolder.itemNumber.text = data[position].id.toString()
    }

    override fun getItemCount() = data.size
}