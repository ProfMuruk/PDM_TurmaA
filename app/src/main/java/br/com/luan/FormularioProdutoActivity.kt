package br.com.luan

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.luan.dao.ProdutoDao
import br.com.luan.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario_produto_activity)

        val salvarProduto = findViewById<Button>(R.id.botao_salvar)

        val produtoDao = ProdutoDao()

        salvarProduto.setOnClickListener{
            val inputNome = findViewById<EditText>(R.id.nome_produto)
            val nome = inputNome.text.toString()

            val inputDescricao = findViewById<EditText>(R.id.descricao_produto)
            val descricao = inputDescricao.text.toString()

            val inputValor = findViewById<EditText>(R.id.valor_produto)
            val textoValor = inputValor.text.toString()
            /*
            * converte o valor em texto para bigdecimal caso
            * o valor não seja branco ou nulo*/
            val valor = if(textoValor.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(textoValor)
            }

            val novoProduto = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            produtoDao.adicionarProduto(novoProduto)

            Log.i("Formulario", "o que veio: $novoProduto")
            Log.i("dao", "produto cadastrado: ${produtoDao.buscarProduto()}")
        }

    }
}