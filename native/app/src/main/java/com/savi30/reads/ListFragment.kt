package com.savi30.reads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.savi30.reads.data.Action
import com.savi30.reads.data.Book
import com.savi30.reads.databinding.FragmentListBinding
import com.savi30.reads.recycler.BookListAdapter

class ListFragment : Fragment(), BookListAdapter.ListItemOnClickListener {
    private lateinit var binding: FragmentListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val args: ListFragmentArgs by navArgs()

    private var data: MutableList<Book> = mutableListOf(
        Book(id = 123, name = "book1", authors = mutableListOf("a1"), noPages = 300),
        Book(id = 124, name = "book2", authors = mutableListOf("a2"), noPages = 300),
        Book(id = 125, name = "book3", authors = mutableListOf("a3"), noPages = 300),
        Book(id = 128, name = "book6", authors = mutableListOf("a6"), noPages = 300)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        initRecyclerView()
        setEventListeners()
        handleNavArgs()
        return binding.root
    }

    private fun handleNavArgs() {
        when (args.action) {
            Action.DELETE -> removeBook(args.book?.id!!)
            Action.ADD -> addBook(args.book)
            else -> return
        }
    }

    private fun addBook(book: Book?) {
        if (book != null) {
            data.add(book)
            viewAdapter.notifyDataSetChanged()
            viewAdapter.notifyItemRangeChanged(0, data.size)
        }
    }

    private fun removeBook(bookId: Int) {
        val idx = data.indexOfFirst { book -> book.id == bookId }
        if (idx > 0) {
            data.removeAt(idx)
            viewAdapter.notifyItemRemoved(idx)
            viewAdapter.notifyItemRangeChanged(idx, data.size)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun setEventListeners() {
        binding.btnAddBook.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToAddBookFragment()
            findNavController().navigate(action)
        }
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(activity)
        viewAdapter = BookListAdapter(data, this)
        recyclerView = binding.bookListRecyclerView.apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onClick(position: Int) {
        val book = data[position]
        val action = ListFragmentDirections.actionListFragmentToDetails(book)
        findNavController().navigate(action)
    }

}
