package Adaptadores

import Modelo.Contacto
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejerciciorecycleviewdef.R

class MiAdaptadorRecycler(var contactos: ArrayList<Contacto>, var context: Context): RecyclerView.Adapter<MiAdaptadorRecycler.ViewHolder>() {

    companion object {
        var seleccionado:Int = -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contactos.get(position)
        holder.bind(item, context, position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_card,parent,false))
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombreContacto = view.findViewById(R.id.txtNombre) as TextView
        val apellidoContacto = view.findViewById(R.id.txtApellidos) as TextView
        val imagen = view.findViewById(R.id.imagenPerfil) as ImageView

        fun bind(MiContacto: Contacto, context: Context, posicion: Int, miAdaptadorRecycler: MiAdaptadorRecycler){
            nombreContacto.text = MiContacto.Nombre
            apellidoContacto.text = MiContacto.Apellidos

            if (MiContacto.Nombre.equals("")){
                val uri = "@drawable/" + MiContacto.FotoPerfil
                val imageResource: Int = context.getResources().getIdentifier(uri, null, context.getPackageName())
                var res:Drawable = context.resources.getDrawable(imageResource)
                imagen.setImageDrawable(res)
            }
            else {
                Glide.with(context).load(MiContacto.FotoPerfil).into(imagen)
            }
            if (posicion == MiAdaptadorRecycler.seleccionado) {
                with(nombreContacto) {
                    this.setTextColor(resources.getColor(R.color.purple_200))
                }
            }
            else {
                with(nombreContacto) {
                    this.setTextColor(resources.getColor(R.color.black))
                }
            }
            itemView.setOnClickListener(View.OnClickListener
            {
                if (posicion == MiAdaptadorRecycler.seleccionado){
                    MiAdaptadorRecycler.seleccionado = -1
                }
                else {
                    MiAdaptadorRecycler.seleccionado = posicion
                }
                //Refresca el viewholder
                miAdaptadorRecycler.notifyDataSetChanged()
            })
        }
    }
}