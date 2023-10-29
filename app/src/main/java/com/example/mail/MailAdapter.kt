package com.example.mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class MailAdapter(val items: ArrayList<MailModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_mail_item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.title.text = items[position].title
        viewHolder.avatar.setImageResource(items[position].avatar)
        viewHolder.starred.isChecked = items[position].starred
        viewHolder.time.text = items[position].time
        viewHolder.content.text = items[position].content

        viewHolder.starred.setOnClickListener {
            items[position].starred = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val title: TextView
        val content: TextView
        val avatar: ImageView
        val starred: CheckBox
        val time: TextView
        init {
            starred = itemView.findViewById(R.id.star_check_box)
            avatar = itemView.findViewById(R.id.avatar_img)
            content = itemView.findViewById(R.id.content_mail)
            title = itemView.findViewById(R.id.title_mail)
            time = itemView.findViewById(R.id.time_mail)
        }

    }
}