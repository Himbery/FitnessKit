package com.ttfh21.testlifehack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var jsonApi: MyApi
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init api
        val retrofit = RetrofitObject.instance
        jsonApi = retrofit.create(MyApi::class.java)



        // View
        companyList.layoutManager = LinearLayoutManager(this)
        companyList.setHasFixedSize(true)
        fetchData()


    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ posts->displayData(posts)},{e :Throwable -> handleError(e)})  )

    }


    private fun displayData(posts: List<Company>?) {
        val adapter = CompanyAdapter(this, posts!!)
        companyList.adapter = adapter


        adapter.setOnItemClickListener(object : CompanyAdapter.OnItemClickListener{
            override fun onItemClick(company: Company) {
                val intent = Intent(this@MainActivity, CompanyDetailActivity::class.java)
                intent.putExtra("starttime", company.startTime)
                intent.putExtra("endtime", company.endTime)
                intent.putExtra("name", company.name)
                intent.putExtra("description", company.description)
                startActivity(intent)
            }
        })
    }
    private fun handleError (e :Throwable){
        e.printStackTrace()
    }


}

