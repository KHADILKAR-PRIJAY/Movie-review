package com.example.project01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project01.databinding.ActivitySecondBinding
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    lateinit var recyclerViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerViewManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerViewManager
        recyclerView.setHasFixedSize(true)


        getMovieReviews().start()
    }

    private fun getMovieReviews(): Thread {
        return Thread {
            val url =
                URL("https://api.nytimes.com/svc/movies/v2/reviews/search.json?opening-date=2020-01-01:2022-10-12&api-key=QXQrXpB2uUTkl66Wh6tVAcEGgCUH1trq")
            val connection = url.openConnection() as HttpsURLConnection
            if (connection.responseCode == 200) {
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, Review::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()
            }
        }
    }


    private fun updateUI(request: Review) {
        runOnUiThread {
            kotlin.run {
                binding.recyclerView.adapter = RecyclerAdapter(request.results!!)

            }
        }
    }
}