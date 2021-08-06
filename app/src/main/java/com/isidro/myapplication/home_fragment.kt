package com.isidro.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.isidro.myapplication.sobreMi_fragment as sobreMi_fragment1


class home_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)

        val recycler: RecyclerView = view.findViewById<RecyclerView>(R.id.recycler_materia)
        recycler.layoutManager = LinearLayoutManager(requireActivity())

        val adapter = materiasAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(), it.nombre, Toast.LENGTH_LONG).show()
        }

        val materiasList: MutableList<materias> = add_new_materia()
        adapter.submitList(materiasList)
        val textEmpty = view.findViewById<TextView>(R.id.home_text)
        if (materiasList.isEmpty()) {
            textEmpty.visibility = View.VISIBLE
        } else {
            textEmpty.visibility = View.GONE
        }

        val addMateria = add_materia()
        val MainActivity = (activity as MainActivity)
        val botton = view.findViewById<FloatingActionButton>(R.id.add)
        botton.setOnClickListener {
            MainActivity.setCurrrentFragment(addMateria)
        }
        return view

    }
        public fun add_new_materia() : MutableList<materias> {
            val lista= mutableListOf(
                materias(1, "Matematicas", "Juanito", materias.ramas.MATEMATICAS),
                materias(2, "Programacion", "Ignacion", materias.ramas.PROGRAMACION)
            )
            println(lista)
            return lista
        }
}