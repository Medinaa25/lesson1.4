package kg.geektech.lesson14.ui.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.lesson14.R
import kg.geektech.lesson14.databinding.ItemBoardBinding

class BoardAdapter(val navController: NavController): RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val list = arrayListOf("Sponge bob", "Patrick", "Squidward")
    private val description = arrayListOf("SquarePants", "Star", "Tentacles")
    private val picture = arrayListOf(R.drawable.ic_spongebob,R.drawable.ic_patrick,R.drawable.ic_squidward)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount() = list.size


    inner class ViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.textTitle.text = list[position]
            binding.textDesc.text = description[position]

            if (position == list.lastIndex) {
                binding.buttonStart.visibility = View.VISIBLE
            } else {
                binding.buttonStart.visibility = View.INVISIBLE
            }
            binding.buttonStart.setOnClickListener {
                navController.navigateUp()
            }

            if (position == 0) {
                binding.btnSkip.visibility = View.VISIBLE
            } else {
                binding.btnSkip.visibility = View.GONE

            }
            binding.btnSkip.setOnClickListener {
                navController.navigateUp()
            }
            binding.imageView.setImageResource(picture[position])


        }
    }
}

