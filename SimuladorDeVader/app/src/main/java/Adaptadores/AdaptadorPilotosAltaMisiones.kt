package Adaptadores

import Modelos.Piloto
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.R

class AdaptadorPilotosAltaMisiones(var pilotos: ArrayList<Piloto>, var context: Context): RecyclerView.Adapter<AdaptadorPilotosAltaMisiones.ViewHolder>() {

    companion object{
        var seleccionado:Int = -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pilotos.get(position)
        holder.bind(item, context, position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.tarjeta_pilotos_crear_misiones, parent,false))
    }

    override fun getItemCount(): Int {
        return pilotos.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombrePiloto = view.findViewById(R.id.etxtNombrePiloto) as TextView
        val experienciaPiloto = view.findViewById(R.id.etxtExperienciaPiloto) as TextView

        fun bind(MiPiloto: Piloto, context: Context, posicion: Int, adaptador: AdaptadorPilotosAltaMisiones){
            nombrePiloto.text = MiPiloto.name
            experienciaPiloto.text= MiPiloto.exp.toString()
            if (posicion == AdaptadorPilotosAltaMisiones.seleccionado) {
                with(nombrePiloto) {
                    this.setTextColor(resources.getColor(R.color.teal_200))
                }
            }
            else {
                with(nombrePiloto) {
                    this.setTextColor(resources.getColor(R.color.black))
                }
            }
            itemView.setOnClickListener(
                View.OnClickListener
            {
                if (posicion == AdaptadorPilotosAltaMisiones.seleccionado){
                    AdaptadorPilotosAltaMisiones.seleccionado = -1
                }
                else {
                    AdaptadorPilotosAltaMisiones.seleccionado = posicion
                }
                //Refresca el viewholder
                adaptador.notifyDataSetChanged()
            })
        }
    }
}