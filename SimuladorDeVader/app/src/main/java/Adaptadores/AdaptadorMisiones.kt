package Adaptadores

import Modelos.Mision
import Modelos.Piloto
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.R

class AdaptadorMisiones (var misiones: ArrayList<Mision>, var context: Context): RecyclerView.Adapter<AdaptadorMisiones.ViewHolder>(){

    companion object{
        var seleccionado:Int = -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = misiones.get(position)
        holder.bind(item, context, position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.tarjeta_misiones, parent,false))
    }

    override fun getItemCount(): Int {
        return misiones.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val codMision = view.findViewById(R.id.txtCodMision) as TextView
        val tipoMision = view.findViewById(R.id.txtTipoMision) as TextView
        val naveUsada = view.findViewById(R.id.txtNaveUsada) as TextView
        fun bind(mision: Mision, context: Context, posicion: Int, adaptador: AdaptadorMisiones){
            codMision.text = mision.code.toString()
            tipoMision.text = mision.missionType
            naveUsada.text = mision.shipLicense
            if (mision.finalized == 1) {
                with(codMision) {
                    this.setTextColor(resources.getColor(R.color.teal_200))
                }
            }
            else if(mision.finalized==0) {
                with(codMision) {
                    this.setTextColor(resources.getColor(R.color.purple_200))
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