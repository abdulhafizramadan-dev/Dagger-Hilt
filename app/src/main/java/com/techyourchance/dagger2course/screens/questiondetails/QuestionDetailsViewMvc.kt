package com.techyourchance.dagger2course.screens.questiondetails

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.questions.QuestionWithBody
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    private val imageLoader: ImageLoader
): BaseViewMvc<QuestionDetailsViewMvc.Listener>(
    layoutInflater,
    parent,
    R.layout.layout_question_details
) {

    interface Listener {
        fun onBackClicked()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView
    private var txtUserName: TextView
    private val imgUser: ImageView

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

        txtUserName = findViewById(R.id.txt_user_name)
        imgUser = findViewById(R.id.img_user)
    }

    fun bindQuestionBody(questionBody: QuestionWithBody) {
        txtQuestionBody.text = Html.fromHtml(questionBody.body, Html.FROM_HTML_MODE_LEGACY)
        txtUserName.text = questionBody.owner.name
        imageLoader.loadImage(questionBody.owner.imageUrl, imgUser)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }
}