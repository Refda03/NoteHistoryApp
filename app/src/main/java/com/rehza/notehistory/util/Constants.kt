package com.rehza.notehistory.util

import com.rehza.notehistory.model.History

object Constants {
    const val TABLE_NAME = "stories"
    const val DATABASE_NAME = "historydatabase"

    fun List<History>?.orPlaceHolderList(): List<History> {
        fun placeHolderList(): List<History> {
            return listOf(History(id = 0, title = "No Story Found", note = "Please create a story.", dateUpdated = ""))
        }
        return if (!this.isNullOrEmpty()){
            this
        } else placeHolderList()
    }
    val historyDetailPlaceHolder = History(note = "Cannot find story details", id = 0, title = "Cannot find story details")
}