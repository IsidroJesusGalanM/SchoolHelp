package com.isidro.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class materiasAdapter:ListAdapter<materias,materiasAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<materias>(){
        override fun areItemsTheSame(oldItem: materias, newItem: materias): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: materias, newItem: materias): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (materias)-> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): materiasAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.materias_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: materiasAdapter.ViewHolder, position: Int) {
        val materia:materias = getItem(position)
        holder.bind(materia)
    }

    inner class ViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val nombreText = view.findViewById<TextView>(R.id.nombre_text)
        val icon = view.findViewById<ImageView>(R.id.icono_materia)

        fun bind(materia: materias){
            nombreText.text = materia.nombre
            val imageId = when(materia.icono){
                materias.ramas.INGLES -> R.drawable.ic_ingles
                materias.ramas.MATEMATICAS ->R.drawable.ic_calculador
                materias.ramas.PROGRAMACION ->R.drawable.ic_programacion_web
            }
            icon.setImageResource(imageId)

            view.setOnClickListener{
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(materia)
                }
            }
        }
    }
}