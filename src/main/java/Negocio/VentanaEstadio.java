/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author fabian
 */
public class VentanaEstadio extends JFrame{
    private JPanel panelLista;
    private ArrayList<Partido> partidos;

    public VentanaEstadio() {
        setTitle("Estadio - Lista de Partidos");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Inicializamos lista de partidos
        partidos = new ArrayList<>();
        //partidos.add(new Partido("15/11/2025", "19:00", "Millonarios", "SantaFe"));
        
        // Panel contenedor con scroll
        panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(panelLista);
        add(scroll, BorderLayout.CENTER);

        // Mostrar los partidos
        mostrarPartidos();
        
        setVisible(true);
    }
    
    private void mostrarPartidos() {
        panelLista.removeAll(); // Limpia por si se actualiza la lista

        for (Partido p : partidos) {
            JPanel panelPartido = new JPanel(new BorderLayout());
            panelPartido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelPartido.setBackground(new Color(240, 240, 240));

            // Información del partido
            String info = "<html><b>" + p.getEquipoLocal() + " vs " + p.getEquipoVisitante() + "</b><br>" +
                    "Fecha: " + p.getFecha() + "<br>" +
                    "Hora: " + p.getHora() + "<br>";

            JLabel lblInfo = new JLabel(info);
            panelPartido.add(lblInfo, BorderLayout.CENTER);

            // Botón para comprar boletas
            JButton btnComprar = new JButton("Comprar");
            btnComprar.addActionListener(e -> comprarBoleta(p));
            panelPartido.add(btnComprar, BorderLayout.EAST);

            panelLista.add(panelPartido);
        }
        
        panelLista.revalidate();
        panelLista.repaint();
    }
    
    private void comprarBoleta(Partido partido) {
        JOptionPane.showMessageDialog(this,
                "Has comprado una boleta para el partido:\n" +
                        partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante() ,
                "Compra exitosa",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaEstadio::new);
    }
}

