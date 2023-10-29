package com.example.mail

data class MailModel(val avatar: Int, val title: String, val content: String, val time: String){
    var starred: Boolean = false
}
