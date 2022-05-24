package kg.geektech.lesson14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kg.geektech.lesson14.databinding.FragmentNewBinding
import kg.geektech.lesson14.models.News

class NewFragment : Fragment() {
    private var _binding: FragmentNewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btbSave.setOnClickListener{
            save()
        }
    }

    private fun save() {
        val text = binding.editText.text.toString()
        val news = News(text, System.currentTimeMillis())
        val bundle = bundleOf("news" to news )
        parentFragmentManager.setFragmentResult("rk_new",bundle)
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}