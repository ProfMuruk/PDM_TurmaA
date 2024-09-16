package br.com.luan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.luan.model.Produto
import java.math.BigDecimal
import java.text.DecimalFormat

class ItemProdutoAdapter(private val produtos: List<Produto>) :
    RecyclerView.Adapter<ItemProdutoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nomeProduto: TextView = itemView.findViewById(R.id.nome_produto)
        val descricaoProduto: TextView = itemView.findViewById(R.id.descricao_produto)
        val valorProduto: TextView = itemView.findViewById(R.id.valor_produto)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        val formatador = DecimalFormat("#,##0.00")

        val valorFormatado = formatador.format(produto.valor)

        holder.nomeProduto.text = produto.nome
        holder.descricaoProduto.text = produto.descricao
        holder.valorProduto.text = valorFormatado
    }

    override fun getItemCount(): Int = produtos.size


}