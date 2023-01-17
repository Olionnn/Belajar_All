package com.anushka.navdemo5


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.nextButton.setOnClickListener {
            if (binding.nameEditText.text.isNotEmpty()){
                val bundle1 : Bundle = bundleOf("user_name" to binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle1)
            } else {
                Toast.makeText(activity,"Please Insert Your Name", Toast.LENGTH_LONG).show()
            }
        }


        return binding.root
    }
}
