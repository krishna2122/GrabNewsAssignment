package com.grab.assignment.krishna.ui.activity

import android.content.Intent
import android.os.Bundle
import com.grab.assignment.krishna.R
import com.grab.assignment.krishna.adapter.NewsHeadLinesAdapter
import com.grab.assignment.krishna.ui.NewsArticleViewModel
import com.grab.assignment.krishna.ui.base.BaseActivity
import com.grab.assignment.krishna.utils.getViewModel
import com.grab.assignment.krishna.utils.load
import com.grab.assignment.krishna.utils.observe
import com.grab.assignment.krishna.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

/**
 * The Main or Starting Activity.
 *
 * @author Krishna Mishra
 * @since 11/07/2020.
 */
class NewsMainActivity : BaseActivity() {

    private val TAG : String =NewsMainActivity::class.java.simpleName
    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        news_list.setEmptyView(empty_view)
        news_list.setProgressView(progress_view)

        val adapter = NewsHeadLinesAdapter {
            //toast("Clicked on item")
            //var url:String;
            val intent = Intent(this, NewsDetailActivity::class.java)
            intent.putExtra("EXTRA_NEWS", it.url);
            startActivity(intent)

        }
        news_list.adapter = adapter
        news_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        // Observing for data change
        newsArticleViewModel.getNewsArticles().observe(this) {
            it.load(news_list) {
                // Update the UI as the data has changed
                it?.let { adapter.notifyItems(it) }
            }
        }


    }
}
