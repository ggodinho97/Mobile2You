package br.com.gabriel.mobile2you.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gabriel.mobile2you.R
import br.com.gabriel.mobile2you.model.Similar
import br.com.gabriel.mobile2you.utils.Constants.Companion.BASE_IMAGE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_similar_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class SimilarMovieAdapter : RecyclerView.Adapter<SimilarMovieAdapter.SimilarVH>() {

    var items: MutableList<Similar> = mutableListOf()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_similar_movie, parent, false)
        return SimilarVH(view)
    }

    override fun onBindViewHolder(holder: SimilarVH, position: Int) {
        holder.populate(items[position])
    }

    override fun getItemCount() = items.size

    inner class SimilarVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(itemSimilar: Similar) {
            with(itemView) {
                Glide.with(context)
                    .load(BASE_IMAGE_URL + itemSimilar.backdrop_path)
                    .into(imgItem)
                tvTitle.text = itemSimilar.title

                var date = itemSimilar.release_date
                var spf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val newDate = spf.parse(date)
                spf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                date = spf.format(newDate)

                tvSubtitle.text = date
            }
        }
    }
}


