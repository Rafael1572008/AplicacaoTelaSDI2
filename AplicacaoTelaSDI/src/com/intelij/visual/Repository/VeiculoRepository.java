package com.intelij.visual.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoRepository {

    // Lista para guardar os veiculos
    private static List<Map<String, String>> veiculos = new ArrayList<>();

    // Adição
    public static void salvarVeiculo(String fabricante, String modelo, String cidade){
        Map<String, String> veiculo = new HashMap<>();
        veiculo.put("Fabricante", fabricante);
        veiculo.put("Modelo", modelo);
        veiculo.put("Cidade", cidade);
        veiculos.add(veiculo);
    }

    // Função para retornar
    public static List<Map<String, String>> listaVeiculos(){
        return veiculos;
    }


}
