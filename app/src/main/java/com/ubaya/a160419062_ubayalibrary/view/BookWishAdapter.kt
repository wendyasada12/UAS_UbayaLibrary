package com.ubaya.a160419062_ubayalibrary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419062_ubayalibrary.R
import com.ubaya.a160419062_ubayalibrary.databinding.BookListItemBinding
import com.ubaya.a160419062_ubayalibrary.model.Book
import com.ubaya.a160419062_ubayalibrary.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookWishAdapter(val bookList: ArrayList<Book>) : RecyclerView.Adapter<BookWishAdapter.BookViewHolder>(), ButtonDetailClickListener, ButtonEditClickListener {
    class BookViewHolder(var view: BookListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookWishAdapter.BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<BookListItemBinding>(inflater,R.layout.book_list_item, parent, false)
        return BookWishAdapter.BookViewHolder(view)

    }



    override fun onBindViewHolder(holder: BookWishAdapter.BookViewHolder, position: Int) {
        holder.view.books = bookList[position]
        holder.view.listener = this
//        val book = bookList[position]
//        with (holder.view){
//            textID.text = book.id
//            textBName.text = book.name
//            textAuthorName.text = book.author
//            buttonDetail.setOnClickListener {
//                val action = book.id?.let { id ->
//                    WishlistFragmentDirections.actionWishToBookDetail(id)
//
//                }
//                if (action != null)
//                {
//                    Navigation.findNavController(it).navigate(action)
//                }
//            }
//            imageBookPhoto.loadImage(book.image, progressLoadingBookPhoto)
//        }
    }
    override fun getItemCount() = bookList.size

    fun updateBookList(newBookList: List<Book>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = WishlistFragmentDirections.actionWishToBookDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonEditClick(v: View) {
        TODO("Not yet implemented")
    }
}