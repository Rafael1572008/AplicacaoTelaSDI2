package com.intelij.visual;

import com.intelij.visual.Repository.VeiculoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class TelaPrincipalSDI extends JFrame {
    private JTable tabelaVeiculos;
    private DefaultTableModel modeloTabela;

    public TelaPrincipalSDI() {

        // Titulo
        setTitle("Sistema de Cadastro de Carros");

        // Dimensões da tela
        setSize(800, 600);

        // Deixar ao centro
        setLocationRelativeTo(null);

        // Botão de 'x' fechar a tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adição de borda
        setLayout(new BorderLayout());

        // Criar menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuCadastroVeiculo = new JMenuItem("Cadastro de Veículo");
        menuCadastro.add(menuCadastroVeiculo);
        menuBar.add(menuCadastro);
        setJMenuBar(menuBar);

        // Criar tabela
        String[] colunas = {"Fabricante", "Modelo", "Cidade"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaVeiculos = new JTable(modeloTabela);
        add(new JScrollPane(tabelaVeiculos), BorderLayout.CENTER);

        // Ação para abrir formulário de cadastro
        menuCadastroVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroVeiculo telaCadastro = new TelaCadastroVeiculo(TelaPrincipalSDI.this);
                telaCadastro.setVisible(true);
            }
        });

        // Carregar veículos existentes (se houver)
        atualizarTabela();
    }

    // Método para atualizar a tabela
    public void atualizarTabela() {
        modeloTabela.setRowCount(0); // limpa tabela
        for (Map<String, String> veiculo : VeiculoRepository.listaVeiculos()) {
            modeloTabela.addRow(new Object[]{
                    veiculo.get("Fabricante"),
                    veiculo.get("Modelo"),
                    veiculo.get("Cidade")
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalSDI principal = new TelaPrincipalSDI();
            principal.setVisible(true);
        });
    }
}
