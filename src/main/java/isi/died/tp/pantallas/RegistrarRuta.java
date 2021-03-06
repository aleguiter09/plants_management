package isi.died.tp.pantallas;

import java.awt.Color;
import javax.swing.*;

import isi.died.tp.dominio.Planta;

import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarRuta extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int ancho = 650, alto = 571;
	private JTextField distancia;
	private JTextField duracion;
	private JTextField peso;
	private JTextField inicio;
	private JTextField fin;

	public RegistrarRuta(Principal principal, JPanel aux) {
		setBounds(350, 0, ancho, alto);
		setBackground(new Color(139, 69, 19));
		setLayout(null);
		
		JLabel lblRegistrarRuta = new JLabel("REGISTRAR RUTA");
		lblRegistrarRuta.setLocation(225, 25);
		lblRegistrarRuta.setSize(200, 25);
		lblRegistrarRuta.setForeground(new Color(255, 255, 255));
		lblRegistrarRuta.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRegistrarRuta.setBackground(new Color(255, 255, 255));
		add(lblRegistrarRuta);
		
		JLabel lblDistanciakm = new JLabel("Distancia (Km) : ");
		lblDistanciakm.setForeground(new Color(255, 255, 255));
		lblDistanciakm.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDistanciakm.setBounds(45, 125, 100, 25);
		add(lblDistanciakm);
		
		distancia = new JTextField();
		distancia.setBounds(339, 125, 86, 25);
		add(distancia);
		distancia.setColumns(10);
		
		JLabel lblDuracinDelViaje = new JLabel("Duración del viaje (Minutos) :  ");
		lblDuracinDelViaje.setForeground(new Color(255, 255, 255));
		lblDuracinDelViaje.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDuracinDelViaje.setBounds(46, 200, 208, 25);
		add(lblDuracinDelViaje);
		
		duracion = new JTextField();
		duracion.setBounds(339, 203, 86, 25);
		add(duracion);
		duracion.setColumns(10);
		
		JLabel lblPesoMaxAceptado = new JLabel("Peso max. aceptado por el camión (Toneladas) :");
		lblPesoMaxAceptado.setForeground(new Color(255, 255, 255));
		lblPesoMaxAceptado.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPesoMaxAceptado.setBounds(45, 275, 279, 25);
		add(lblPesoMaxAceptado);
		
		peso = new JTextField();
		peso.setBounds(339, 275, 86, 25);
		add(peso);
		peso.setColumns(10);
		
		
		JLabel lblIdPlantaOrigen = new JLabel("ID planta origen :");
		lblIdPlantaOrigen.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdPlantaOrigen.setForeground(new Color(255, 255, 255));
		lblIdPlantaOrigen.setBounds(45, 350, 100, 25);
		add(lblIdPlantaOrigen);
		
		JLabel lblIdPlantaDestino = new JLabel("ID planta destino:");
		lblIdPlantaDestino.setForeground(Color.WHITE);
		lblIdPlantaDestino.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdPlantaDestino.setBounds(45, 425, 100, 25);
		add(lblIdPlantaDestino);
		
		inicio = new JTextField();
		inicio.setBounds(339, 350, 86, 25);
		add(inicio);
		inicio.setColumns(10);
		
		fin = new JTextField();
		fin.setBounds(339, 425, 86, 25);
		add(fin);
		fin.setColumns(10);
		
		Button cancelar = new Button("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cancelar?","ALERTA!",JOptionPane.YES_NO_OPTION);
				if(resp != 1) {
					setVisible(false);
					aux.setVisible(true);
				}
			}
		});
		cancelar.setBounds(525, 519, 70, 22);
		add(cancelar);
		
		Button aceptar = new Button("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(distancia.getText().isEmpty()||duracion.getText().isEmpty()||peso.getText().isEmpty()||inicio.getText().isEmpty()||fin.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos","¡ERROR!", JOptionPane.WARNING_MESSAGE);
				else {
					float dist = Float.valueOf(distancia.getText().trim()).floatValue();
					float durac = Float.valueOf(duracion.getText().trim()).floatValue();
					float pes = Float.valueOf(peso.getText().trim()).floatValue();
					int id1 = Integer.valueOf(inicio.getText().trim()).intValue();
					int id2 = Integer.valueOf(fin.getText().trim()).intValue();
					Planta in = null;
					Planta fn = null;
					for(int i=0; i<principal.grafo.vertices().size(); i++) {
						if(principal.grafo.vertices().get(i).getValor().getId() == id1) 
							in = principal.grafo.vertices().get(i).getValor();
						if(principal.grafo.vertices().get(i).getValor().getId() == id2) 
							fn = principal.grafo.vertices().get(i).getValor();
					}
					principal.grafo.conectar(in,fn,dist,durac,pes);
					JOptionPane.showMessageDialog(null, "¡Ruta registrada con éxito! \nID Insumo: \nInicio en: Planta "+in.getNombre()+"\nFin en: Planta "+fn.getNombre());
				}
			}
		});
		aceptar.setBounds(417, 519, 70, 22);
		add(aceptar);

	}
}
