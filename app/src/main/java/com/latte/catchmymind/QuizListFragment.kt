package com.latte.catchmymind

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "QuizListFragment"

class QuizListFragment: Fragment() {

    private lateinit var quizRecyclerView: RecyclerView
    private var adapter: QuizAdapter? = null

    private val quizListViewModel: QuizListViewModel by lazy {
        ViewModelProvider(this).get(QuizListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, " onCreate !!")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_list, container, false)
        quizRecyclerView = view.findViewById(R.id.quiz_recycler_view) as RecyclerView
        quizRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val quizList = quizListViewModel.quizList
        adapter = QuizAdapter(quizList)
        quizRecyclerView.adapter = adapter
    }

    private inner class QuizHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var quiz: Quiz

        private val questionTextView: TextView = itemView.findViewById(R.id.quiz_question)
        private val answerTextView: TextView = itemView.findViewById(R.id.quiz_answer)

        fun bind(quiz: Quiz) {
            this.quiz = quiz
            questionTextView.text = this.quiz.question
            answerTextView.text = this.quiz.answer
        }
    }

    private inner class QuizAdapter(var quizList: List<Quiz>)
        : RecyclerView.Adapter<QuizHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizHolder {
            val view = layoutInflater.inflate(R.layout.quiz_list_item,parent,false)
            return QuizHolder(view)
        }

        override fun onBindViewHolder(holder: QuizHolder, position: Int) {
            val quiz = quizList[position]
            holder.bind(quiz)
        }

        override fun getItemCount() = quizList.size

    }


    companion object{
        fun newInstance(): QuizListFragment{
            return QuizListFragment()
        }
    }
}