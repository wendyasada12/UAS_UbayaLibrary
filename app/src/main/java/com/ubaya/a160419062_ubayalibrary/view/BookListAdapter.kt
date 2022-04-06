package com.ubaya.a160419062_ubayalibrary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419062_ubayalibrary.R
import com.ubaya.a160419062_ubayalibrary.model.Book
import com.ubaya.a160419062_ubayalibrary.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter(val bookList: ArrayList<Book>) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){
    class BookViewHolder(var view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        with (holder.view){
            textID.text = book.id
            textBName.text = book.name
            textAuthorName.text = book.author
            buttonDetail.setOnClickListener {
                val action = book.id?.let { id ->
                    BookListFragmentDirections.actionToBookDetail(id)

                }
                if (action != null)
                {
                    Navigation.findNavController(it).navigate(action)
                }
            }
            imageBookPhoto.loadImage(book.image, progressLoadingBookPhoto)
        }
    }

    override fun getItemCount() = bookList.size

    fun updateBookList(newBookList: ArrayList<Book>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }
}