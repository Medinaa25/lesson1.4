package kg.geektech.lesson14.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kg.geektech.lesson14.R
import kg.geektech.lesson14.databinding.FragmentHomeBinding
import kg.geektech.lesson14.models.News

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter : NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NewsAdapter {
            val news = adapter.getItem(it)
            Toast.makeText(requireContext(), news.title, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.newFragment)
        }


            parentFragmentManager.setFragmentResultListener(
                "rk_news",
                viewLifecycleOwner
            ) { _, bundle ->
                val news = bundle.getSerializable("news") as News
                Log.e("Home", "text=$news")
                adapter.addItem(news)
            }

            binding.recyclerView.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}