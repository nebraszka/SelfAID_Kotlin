package pl.nebraszka.selfaid.emotions_journal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_menu.view.*
import pl.nebraszka.selfaid.R

class MainMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)

        view.btnEmotionsJournal.setOnClickListener {
            val fragment = EmotionsJournalMenu()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commit()
        }

        return view
    }
}