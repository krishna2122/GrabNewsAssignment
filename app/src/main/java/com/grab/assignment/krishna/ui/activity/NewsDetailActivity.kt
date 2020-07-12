package com.grab.assignment.krishna.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import com.grab.assignment.krishna.R
import com.grab.assignment.krishna.ui.base.BaseActivity
import kotlinx.android.synthetic.main.webview_detail_activity.*
import android.webkit.WebViewClient


/**
 * Webview Activity  to display details news
 * @author Krishna.mishra
 * @since 11/07/2020.
 */

class NewsDetailActivity : AppCompatActivity() {

    val webView: WebView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_detail_activity)
        var webView: WebView = findViewById<WebView>(R.id.webview_id)
        //val bundle: Bundle? = intent.extras
        var strURL: String = intent.getStringExtra("EXTRA_NEWS") // 2
        webView.setWebViewClient(WebViewClient())
        webView.loadUrl(strURL);

    }



}