package kg.geektech.lesson14

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kg.geektech.lesson14.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageListener()
    }

    private fun imageListener(){
        binding.imageView.setOnClickListener(){
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            launcher.launch(intent)
        }
    }

      private val  launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                 if (it.resultCode == AppCompatActivity.RESULT_OK) {
                     val image = it.data?.data
                     if (image != null) {
                         binding.imageView.setImageURI(image)
                     }
                 }
             }



    override fun onDestroyView() {
                 super.onDestroyView()
                 _binding = null
             }
         }

