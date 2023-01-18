package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitdemo.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retService : AlbumService
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //val textView = findViewById<TextView>(R.id.text_view)

        // Logic Buat Edit Text
        //val abs : Int = 1

        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        //getRequestWithQueryParameters()

        // getRequsetPathParameters()

        uploadAlbum()

    }


    private fun getRequestWithQueryParameters() {
        val responseLiveData:LiveData<Response<Album>> = liveData {
            val response = retService.getAlbum()
            emit(response)

            // Query Parameter
            // val response1 = retService.getSortedAlbum(abs)
            //emit(response1)
        }
        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()){
                    val albumItem = albumList.next()
                    val result = " "+"Album TiTle : ${albumItem.title}"+"\n"+
                            " "+"Album Id : ${albumItem.id}"+"\n"+
                            " "+"Album User Id : ${albumItem.userId}"+"\n\n\n"
                    //Log.i("MyTag", albumItem.title)

                    //binding.textView.append(result)
                    binding.textView.append(result)
                }
            }
        })
    }

    private fun  getRequsetPathParameters(){
        // path parameter
        val pathResponse : LiveData<Response<AlbumItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadAlbum() {
        val album = AlbumItem(0, "My Title",3)

        val postResponse : LiveData<Response<AlbumItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, Observer {
            val receivedAlbumItem : AlbumItem? = it.body()
            val result = " "+"Album TiTle : ${receivedAlbumItem?.title}"+"\n"+
                         " "+"Album Id : ${receivedAlbumItem?.id}"+"\n"+
                         " "+"Album User Id : ${receivedAlbumItem?.userId}"+"\n\n\n"
            binding.textView.text = result
        })
    }



}