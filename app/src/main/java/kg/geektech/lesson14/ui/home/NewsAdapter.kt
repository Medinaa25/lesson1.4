package kg.geektech.lesson14.ui.home

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.lesson14.databinding.ItemNewsBinding
import kg.geektech.lesson14.models.News

class NewsAdapter(private val onClick: (position: Int) -> Unit): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private val list = arrayListOf<News>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
holder.bind(list[position])

    }

    override fun getItemCount() = list.size


    fun addItem(news : News?) {
        news?.let { list.add(0,it)
            notifyItemInserted(list.lastIndexOf(news))
        }
    }

    fun getItem(it: Int): News {
        return list[it]
    }

    inner class ViewHolder(private var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(news: News) {
            binding.textTitle.text = news.title
        }
    }
}