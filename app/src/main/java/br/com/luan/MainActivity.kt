package br.com.luan

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luan.model.Produto
import java.math.BigDecimal

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val nomeProduto = findViewById<TextView>(R.id.nome_produto)
        nomeProduto.setText("Maçã")
        código exemplo
        */

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemProdutoAdapter(produtos = listOf(
            Produto(nome = "Maçã", descricao = "verde", valor = BigDecimal(15.99)),
            Produto(nome = "Maçã", descricao = "verde", valor = BigDecimal(15.99)),
            Produto(nome = "Maçã", descricao = "verde", valor = BigDecimal(15.99))
        ))

        recyclerView.layoutManager = (LinearLayoutManager(this))

    }
}