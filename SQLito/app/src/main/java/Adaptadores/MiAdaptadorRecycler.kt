package Adaptadores

import Modelo.Persona
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sqlito.R

class MiAdaptadorRecycler(var Personas: ArrayList<Persona>, var context: Context): RecyclerView.Adapter<MiAdaptadorRecycler.ViewHolder>() {
    companion object {
        var seleccionado:Int = -1
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Personas.get(position)
        holder.bind(item, context, position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_card,parent,false))
    }
    override fun getItemCount(): Int {
        return Personas.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val Nombre = view.findViewById(R.id.txtNombre) as TextView
        val Edad = view.findViewById(R.id.txtEdad) as TextView
        val DNI = view.findViewById(R.id.txtDNI) as TextView

        fun bind(perso: Persona, context: Context, posicion: Int, miAdaptadorRecycler: MiAdaptadorRecycler){
            Nombre.text = perso.Nombre
            Edad.text = perso.Edad
            DNI.text = perso.DNI
            if (posicion == MiAdaptadorRecycler.seleccionado) {
                with(Nombre) {
                    this.setTextColor(resources.getColor(R.color.purple_200))
                }
            }
            else {
                with(Nombre) {
                    this.setTextColor(resources.getColor(R.color.black))
                }
            }
            itemView.setOnClickListener(View.OnClickListener{
                if (posicion == MiAdaptadorRecycler.seleccionado){
                    MiAdaptadorRecycler.seleccionado = -1
                }
                else {
                    MiAdaptadorRecycler.seleccionado = posicion
                }
                //Refresca el viewholder
                //miAdaptadorRecycler.notifyDataSetChanged()
            })
        }
    }
}