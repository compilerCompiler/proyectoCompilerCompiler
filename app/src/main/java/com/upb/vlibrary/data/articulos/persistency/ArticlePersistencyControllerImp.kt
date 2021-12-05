package com.upb.vlibrary.data.articulos.persistency

import com.upb.vlibrary.App
import com.upb.vlibrary.Books

class ArticlePersistencyControllerImp:ArticlePersistencyController {
    private val db = App.db

    override fun getAllbooks(): List<Books> {
        return db.articleDao().getAllBooks()
    }

    override fun saveBooks(books: List<Books>) {
        db.articleDao().saveBooks(books)
    }

    override fun filterBooksByDisponibilidad(disponibilidadCheck: Boolean): List<Books> {
        return db.articleDao().filterBooksByDisponibility(disponibilidadCheck)
    }

}