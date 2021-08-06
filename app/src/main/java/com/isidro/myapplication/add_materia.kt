package com.isidro.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class add_materia : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_materia, container, false)

        val spinner = view.findViewById<Spinner>(R.id.select_rama)
        val ramas = materias.ramas.values()
        val lista = ramas

        val adaptador  = ArrayAdapter(requireActivity(),R.layout.spinner_styles,lista)
        adaptador.setDropDownViewResource(R.layout.simple_spinner_dropdown)
        spinner.adapter = adaptador

        val button = view.findViewById<Button>(R.id.agregar_materia)
        val mainActivity = (activity as MainActivity)
        val homeFragment = home_fragment()


        return view
    }
}