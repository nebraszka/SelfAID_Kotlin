package pl.nebraszka.selfaid.emotions_journal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_emotion_description.view.*
import pl.nebraszka.selfaid.R

class EmotionDescription : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_emotion_description, container, false)

        view.tvEmotionName.text = arguments?.getString("EXTRA_EMOTION_NAME")
        view.tvEmotionDescribtion.text = arguments?.getString("EXTRA_EMOTION_DESCRIPTION")

        return view
    }
}