package Adaptadores

import Modelos.Nave
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.R

class AdaptadorNavesAltaMisiones(var naves: ArrayList<Nave>, var context: Context): RecyclerView.Adapter<AdaptadorNavesAltaMisiones.ViewHolder>()  {
    companion object{
        var seleccionado:Int = -1
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objetos = naves.get(position)
        holder.bind(objetos, context, position, this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorNavesAltaMisiones.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.tarjeta_naves_crear_misiones,parent,false))
    }
    override fun getItemCount(): Int {
        return naves.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val matriculaNave = view.findViewById(R.id.txtMatricula) as TextView
        val tipoNave = view.findViewById(R.id.txtTipoDeNave) as TextView

        fun bind(MiNave: Nave, context: Context, posicion: Int, adaptador: AdaptadorNavesAltaMisiones){
            matriculaNave.text = MiNave.license
            tipoNave.text= MiNave.type
            if (posicion == AdaptadorNavesAltaMisiones.seleccionado) {
                with(matriculaNave) {
                    this.setTextColor(resources.getColor(R.color.teal_200))
                }
            }
            else {
                with(matriculaNave) {
                    this.setTextColor(resources.getColor(R.color.black))
                }
            }
            itemView.setOnClickListener(
                View.OnClickListener
                {
                    if (posicion == seleccionado){
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