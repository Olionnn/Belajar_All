package com.anushka.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anushka.viewmodelscopedemo.model.User
import com.anushka.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.*
import java.io.Closeable


class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository()
    // jika nullable maka ditambahkkan <user>?>
    var users : MutableLiveData<List<User>> = MutableLiveData()
// private val myJob = Job()
// private val myScope = CoroutineScope(Dispatchers.IO + myJob)

 fun getUserData(){
    // myScope.launch {
         //write some code
     viewModelScope.launch {
         // jika nullable maka ditambahkkan <user>? = null

         var  result: List<User>
         withContext(Dispatchers.IO){
             result = userRepository.getUser()
         }
         //write some code
         users.value = result
     }

 }

//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }

}