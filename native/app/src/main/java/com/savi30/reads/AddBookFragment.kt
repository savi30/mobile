package com.savi30.reads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.savi30.reads.data.Action
import com.savi30.reads.data.Book
import com.savi30.reads.databinding.FragmentAddBookBinding


class AddBookFragment : Fragment() {
    lateinit var binding: FragmentAddBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_book, container, false)
        setEventListeners()
        return binding.root
    }

    private fun setEventListeners() {
        binding.buttonSave.setOnClickListener {
            val book = Book()
            book.id = binding.etId.text.toString().toInt()
            book.name = binding.etName.text.toString()
            book.noPages = binding.etNoPages.text.toString().toInt()
            book.authors = binding.etAuthors.text.toString().split(" ")
            findNavController().navigate(
                AddBookFragmentDirections.actionAddBookFragmentToListFragment(
                    book,
                    Action.ADD
                )
            )
        }
    }
}
