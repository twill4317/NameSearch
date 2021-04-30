package com.godaddy.namesearch

class NameSearchRepository constructor(private val nameSearchServices: NameSearchServices) {
    fun getPaymentMethods(){ nameSearchServices.getPaymentMethods() }
    fun performSearch(query: String) {nameSearchServices.performSearch(query)}
    fun postPayments(){nameSearchServices.postPayments()}
    fun postLogin(username: String, password: String){nameSearchServices.postLogin(username, password)}
}