package br.com.arc.main;

import br.com.arc.beans.CategoriaDoacao;
import br.com.arc.beans.ItemDoado;
import br.com.arc.dao.ItemDoadoDAO;

import java.sql.SQLException;
import java.util.List;

public class TesteItens {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ItemDoadoDAO itemDoadoDAO = new ItemDoadoDAO();
        List<ItemDoado> listaItens = itemDoadoDAO.selecionar();

        for (ItemDoado itens : listaItens) {
            System.out.println("Nome: " + itens.getNome());
            System.out.println("Descrição: " + itens.getDescricao());
            System.out.println("Quantidade: " + itens.getQuantidade());
            CategoriaDoacao categoria = itens.getCategoria();
            System.out.println("Categoria: " + categoria.getNome());
        }
    }

}
