package br.com.luan.dao

import br.com.luan.model.Produto

/*DATA ACCESS Object*/
class ProdutoDao {
    fun adicionarProduto(produto : Produto){
        produtos.add(produto)
    }
    fun buscarProduto() : List<Produto>{
        return produtos.toList()
    }

    companion object{
        private val produtos = mutableListOf<Produto>()
    }
}