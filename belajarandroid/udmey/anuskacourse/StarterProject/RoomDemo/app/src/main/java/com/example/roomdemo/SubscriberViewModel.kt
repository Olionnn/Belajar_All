package com.example.roomdemo


import android.util.Patterns
import androidx.lifecycle.*
import com.example.roomdemo.db.Subscriber
import com.example.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {




    // menggunalan LiveData Menggabil Data
    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete : Subscriber

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = statusMessage



    init {
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){

        if(inputName.value == null){
            statusMessage.value = Event("Masukan Nama Anda")
        }else if (inputEmail.value == null){
            statusMessage.value = Event("Masukan Email Anda")
        }else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()){
            statusMessage.value = Event("Format Email Salah!! ex: aaa@mail?.aaa")
        }else {
            if (isUpdateOrDelete){
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            }else{
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0,name,email))
                inputName.value = ""
                inputEmail.value = ""
            }
        }
    }


    fun clearOrDelete(){
        if (isUpdateOrDelete){
            delete(subscriberToUpdateOrDelete)
        }else {
            clearAll()
        }

    }

    private fun insert(subscriber : Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val newRowId = repository.insert(subscriber)
        withContext(Dispatchers.Main){
            if (newRowId>-1){
                statusMessage.value = Event("Subscriber Dimasukan $newRowId")
            }else{
                statusMessage.value = Event("Insert Error!!!")
            }

        }
    }

    private fun update(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val numberOfRow = repository.update(subscriber)
        withContext(Dispatchers.Main){
            if (numberOfRow > 0) {
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "Save"
                clearAllOrDeleteButtonText.value = "Clear"
                statusMessage.value = Event("$numberOfRow Subscriber Diedit ")
            } else {
                statusMessage.value = Event("Edit Error!!!")
            }
        }
    }

    private fun delete(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val noRowDeleted = repository.delete(subscriber)
        withContext(Dispatchers.Main){
            if (noRowDeleted > 0) {
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "Save"
                clearAllOrDeleteButtonText.value = "Clear"
                statusMessage.value = Event("Subscriber Dihapus")
            } else {
                statusMessage.value = Event("Hapus Data Error!!")
            }

        }
    }

    private fun clearAll() = viewModelScope.launch(Dispatchers.IO) {
        val deleted = repository.deleteAll()
        withContext(Dispatchers.Main){
            if (deleted > 0){
                statusMessage.value = Event("Subscriber DiHapus Semua")
            } else {
                statusMessage.value = Event("Terjadi Error Saat Menghapus Semua Data!!!")
            }


        }
    }



    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    // Menyimpan Data Subs With Flow
//    fun getSavedSubscribers() =
//        liveData {
//        repository.subscribers.collect {
//            emit(it)
//        }
//    }

}