package com.savi30.reads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.savi30.reads.data.Action
import com.savi30.reads.databinding.FragmentDetailsBinding
import java.io.Serializable


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    private val args: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        setEventListeners()
        return binding.root
    }

    private fun setEventListeners() {
        binding.buttonDelete.setOnClickListener {
            val action =
                DetailsFragmentDirections.actionDetailsToListFragment(args.book, Action.DELETE)
            findNavController().navigate(action)
        }
        binding.buttonEdit.setOnClickListener {
            binding.etName.isEnabled = true
            binding.etNoPages.isEnabled = true
            binding.buttonEdit.visibility = View.GONE
            binding.buttonSave.visibility = View.VISIBLE
        }
        binding.buttonSave.setOnClickListener {
            binding.etName.isEnabled = false
            binding.etNoPages.isEnabled = false
            binding.buttonEdit.visibility = View.VISIBLE
            binding.buttonSave.visibility = View.GONE
            this.args.book.name = binding.etName.text.toString()
            this.args.book.noPages = binding.etNoPages.text.toString().toInt()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val book = args.book
        binding.book = book
    }
}
