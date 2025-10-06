package com.intelij.visual;

import com.intelij.visual.Repository.VeiculoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroVeiculo extends JFrame {
    public TelaCadastroVeiculo(TelaPrincipalSDI telaPrincipal) {
        setTitle("Cadastro de Veículo");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblFabricante = new JLabel("Fabricante:");
        JTextField txtFabricante = new JTextField();
        JLabel lblModelo = new JLabel("Modelo:");
        JTextField txtModelo = new JTextField();
        JLabel lblCidade = new JLabel("Cidade:");
        JTextField txtCidade = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(lblFabricante);
        panel.add(txtFabricante);
        panel.add(lblModelo);
        panel.add(txtModelo);
        panel.add(lblCidade);
        panel.add(txtCidade);
        panel.add(btnSalvar);
        panel.add(btnCancelar);

        add(panel);

        // Cancelar fecha a janela
        btnCancelar.addActionListener(e -> dispose());

        // Salvar adiciona à lista e atualiza tabela na tela principal
        btnSalvar.addActionListener(e -> {
            VeiculoRepository.salvarVeiculo(
                    txtFabricante.getText(),
                    txtModelo.getText(),
                    txtCidade.getText()
            );

            telaPrincipal.atualizarTabela();
            JOptionPane.showMessageDialog(null, "Veículo cadastrado!");
            dispose();
        });
    }
}
