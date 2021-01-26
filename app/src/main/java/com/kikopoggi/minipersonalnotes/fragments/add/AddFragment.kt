package com.kikopoggi.minipersonalnotes.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kikopoggi.minipersonalnotes.R
import com.kikopoggi.minipersonalnotes.data.NotesData
import com.kikopoggi.minipersonalnotes.data.NotesViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    private val mNotesViewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_add){
            insertDataToDb()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {

        val mTitle = title.text.toString()
        val mDescription = description.text.toString()

        val validation = verifyDataFromUser(mTitle, mDescription)
        if(validation){
            val newData = NotesData(
              0,
              mTitle,
              mDescription
            )
            mNotesViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Adicionado com sucesso!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Por favor complete todos os campos.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun verifyDataFromUser(title: String, description: String): Boolean {
        return if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            false
        } else !(title.isEmpty() || description.isEmpty())
    }

}