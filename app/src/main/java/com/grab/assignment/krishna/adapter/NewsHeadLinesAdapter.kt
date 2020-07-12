package com.grab.assignment.krishna.adapter
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.grab.assignment.krishna.R
import com.grab.assignment.krishna.model.NewsArticles
import com.grab.assignment.krishna.utils.inflate
import kotlinx.android.synthetic.main.row_news_article.view.*
import java.util.Collections.emptyList

/**
 * The News adapter to show the news in a list.
 *
 * @author Krishna.mishra
 * @since 11/07/2020.
 */
class NewsHeadLinesAdapter(private val listener: (NewsArticles) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<NewsHeadLinesAdapter.NewsHolder>() {

    /**
     * List of news articles
     */
    private var newsArticles: List<NewsArticles> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.row_news_article))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(newsArticles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = newsArticles.size

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {
            //news_title.text = newsArticle.title
            //news_description.text = newsArticle.description
            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            tvListItemDateTime.text = newsArticle.publishedAt
            Glide.with(context)
                    .load(newsArticle.urlToImage)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.img_test_one)
                            .error(R.drawable.img_test_one)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(ivNewsImage)


            setOnClickListener { listener(newsArticle) }


        }

    }

    /**
     * function to set new data on updating
     */
    fun notifyItems(items: List<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}