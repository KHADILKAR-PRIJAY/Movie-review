package com.example.project01
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerAdapter (private val dataSet: List<Results>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var publishDate: TextView
        lateinit var textViewTitle: TextView
        lateinit var textViewheadline: TextView
        lateinit var criticName: TextView
        lateinit var textViewsummery: TextView
        lateinit var imageView: ImageView
        init {

            textViewTitle = view.findViewById<TextView>(R.id.movieTitle)
            textViewheadline = view.findViewById<TextView>(R.id.movieheadline)
            textViewsummery = view.findViewById<TextView>(R.id.movieSummary)
            imageView = view.findViewById(R.id.imageView)
            criticName = view.findViewById(R.id.textViewCritic)
            publishDate= view.findViewById(R.id.textViewPubliDate)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview_item, viewGroup, false)


        val lp = view.layoutParams
        view.layoutParams = lp


        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.textViewTitle.text = (dataSet.get(position).display_title)
        viewHolder.textViewheadline.text = dataSet.get(position).headline
        viewHolder.textViewsummery.text = dataSet.get(position).summary_short
        viewHolder.criticName.text = dataSet.get(position).byline
        viewHolder.publishDate.text = dataSet.get(position).publication_date

        Picasso.get().load(dataSet.get(position).multimedia?.src).into(viewHolder.imageView)
    }


    override fun getItemCount():Int {
        return dataSet.size
    }
}