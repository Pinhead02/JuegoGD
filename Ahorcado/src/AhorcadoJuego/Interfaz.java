package AhorcadoJuego;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Miguel Angel Lopez Torralba
 * @since 2013
 * 
 */
public class Interfaz extends javax.swing.JFrame {
	Ahorcado1 game = new Ahorcado1();
	Color color = new Color(200, 0, 0);

	/**
	 * @param args
	 *            la linea de argumentos
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Interfaz().setVisible(true);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * inicia el interfaz del juego.
	 * 
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public Interfaz() throws LineUnavailableException, IOException,
			UnsupportedAudioFileException {
		iniciarComponentes();
		this.setTitle("AHORCADO - por García-Basualdo-Giusti");
		restaurar_color();
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		mntmMenu = new JMenuItem("Ayuda");
		mntmMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Bienvenido al ahorcado;\nen este juego debes de averiguar cual es la palabra secreta seleccionando letras\n antes de morir en la horca, si lo consigues escaparas de lo contrario habras perdido\nselecciona las letras y adivina la palabra secreta, antes de acabar colgado");
			}
		});
		mnMenu.add(mntmMenu);

		mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Autor: Miguel Angel Lopez Torralba\nAhoracado 1.0M\nContacto: miguel.a.torralba@gmail.com");
			}
		});
		mnMenu.add(mntmAcercaDe);
		this.repaint();
		/**
		 * las siguienes lineas introducen el sonido en el juego.
		 */
		Clip sonido1 = AudioSystem.getClip();// Lanza la excepcion del
		// constructor

		sonido1.open(AudioSystem.getAudioInputStream(new File(
				"src/icon/music.wav")));
		sonido1.start();
		sonido1.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Este método es llamado desde el contructor para inicizalizar el entorno
	 * grafico.
	 * 
	 */
	private void iniciarComponentes() {

		jPanel1 = new javax.swing.JPanel();
		emogrande = new javax.swing.JLabel();
		emogrande.setBackground(Color.WHITE);
		jPanel2 = new javax.swing.JPanel();
		button_A = new javax.swing.JButton();
		button_B = new javax.swing.JButton();
		button_C = new javax.swing.JButton();
		button_D = new javax.swing.JButton();
		button_E = new javax.swing.JButton();
		button_F = new javax.swing.JButton();
		button_G = new javax.swing.JButton();
		button_H = new javax.swing.JButton();
		button_I = new javax.swing.JButton();
		button_J = new javax.swing.JButton();
		button_K = new javax.swing.JButton();
		button_L = new javax.swing.JButton();
		button_M = new javax.swing.JButton();
		button_N = new javax.swing.JButton();
		button_Ñ = new javax.swing.JButton();
		button_O = new javax.swing.JButton();
		button_P = new javax.swing.JButton();
		button_Q = new javax.swing.JButton();
		button_R = new javax.swing.JButton();
		button_S = new javax.swing.JButton();
		button_T = new javax.swing.JButton();
		button_U = new javax.swing.JButton();
		button_V = new javax.swing.JButton();
		button_W = new javax.swing.JButton();
		button_X = new javax.swing.JButton();
		button_Y = new javax.swing.JButton();
		button_Z = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		jPanel4 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		texto = new javax.swing.JTextField();
		emo = new javax.swing.JLabel();
		emo.setBackground(Color.LIGHT_GRAY);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		setResizable(false);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		emogrande.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/icon/ahorcado_5.jpg")));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				emogrande));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				emogrande));

		/**
		 * Los siguientes metodos declaran las funciones de las letras dentro
		 * del teclado del programa.
		 */
		jPanel2.setBackground(Color.LIGHT_GRAY);
		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("   Teclado   "));
		jPanel2.setLayout(new java.awt.GridLayout(6, 5));

		button_A.setText("A");
		button_A.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_AActionPerformed(evt);
			}
		});
		jPanel2.add(button_A);

		button_B.setText("B");
		button_B.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_BActionPerformed(evt);
			}
		});
		jPanel2.add(button_B);

		button_C.setText("C");
		button_C.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_CActionPerformed(evt);
			}
		});
		jPanel2.add(button_C);

		button_D.setText("D");
		button_D.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_DActionPerformed(evt);
			}
		});
		jPanel2.add(button_D);

		button_E.setText("E");
		button_E.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_EActionPerformed(evt);
			}
		});
		jPanel2.add(button_E);

		button_F.setText("F");
		button_F.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_FActionPerformed(evt);
			}
		});
		jPanel2.add(button_F);

		button_G.setText("G");
		button_G.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_GActionPerformed(evt);
			}
		});
		jPanel2.add(button_G);

		button_H.setText("H");
		button_H.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_HActionPerformed(evt);
			}
		});
		jPanel2.add(button_H);

		button_I.setText("I");
		button_I.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_IActionPerformed(evt);
			}
		});
		jPanel2.add(button_I);

		button_J.setText("J");
		button_J.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_JActionPerformed(evt);
			}
		});
		jPanel2.add(button_J);

		button_K.setText("K");
		button_K.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_KActionPerformed(evt);
			}
		});
		jPanel2.add(button_K);

		button_L.setText("L");
		button_L.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_LActionPerformed(evt);
			}
		});
		jPanel2.add(button_L);

		button_M.setText("M");
		button_M.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_MActionPerformed(evt);
			}
		});
		jPanel2.add(button_M);

		button_N.setText("N");
		button_N.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_NActionPerformed(evt);
			}
		});
		jPanel2.add(button_N);

		button_Ñ.setText("Ñ");
		button_Ñ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_ÑActionPerformed(evt);
			}
		});
		jPanel2.add(button_Ñ);

		button_O.setText("O");
		button_O.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_OActionPerformed(evt);
			}
		});
		jPanel2.add(button_O);

		button_P.setText("P");
		button_P.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_PActionPerformed(evt);
			}
		});
		jPanel2.add(button_P);

		button_Q.setText("Q");
		button_Q.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_QActionPerformed(evt);
			}
		});
		jPanel2.add(button_Q);

		button_R.setText("R");
		button_R.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_RActionPerformed(evt);
			}
		});
		jPanel2.add(button_R);

		button_S.setText("S");
		button_S.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_SActionPerformed(evt);
			}
		});
		jPanel2.add(button_S);

		button_T.setText("T");
		button_T.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_TActionPerformed(evt);
			}
		});
		jPanel2.add(button_T);

		button_U.setText("U");
		button_U.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_UActionPerformed(evt);
			}
		});
		jPanel2.add(button_U);

		button_V.setText("V");
		button_V.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_VActionPerformed(evt);
			}
		});
		jPanel2.add(button_V);

		button_W.setText("W");
		button_W.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_WActionPerformed(evt);
			}
		});
		jPanel2.add(button_W);

		button_X.setText("X");
		button_X.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_XActionPerformed(evt);
			}
		});
		jPanel2.add(button_X);

		button_Y.setText("Y");
		button_Y.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_YActionPerformed(evt);
			}
		});
		jPanel2.add(button_Y);

		button_Z.setText("Z");
		button_Z.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_ZActionPerformed(evt);
			}
		});
		jPanel2.add(button_Z);

		jPanel3.setBackground(Color.LIGHT_GRAY);
		jPanel3.setBorder(javax.swing.BorderFactory
				.createTitledBorder("   Inicio   "));

		jButton1.setText("Iniciar juego");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 281,
								Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 93,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(Color.LIGHT_GRAY);
		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jPanel5.setBackground(Color.LIGHT_GRAY);
		jPanel5.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Palabra secreta"));

		texto.setBackground(new java.awt.Color(0, 0, 0));
		texto.setEditable(false);
		texto.setFont(new java.awt.Font("Tahoma", 1, 24));
		texto.setForeground(new java.awt.Color(255, 255, 255));
		texto.setText("");
		texto.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel5Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(texto,
								javax.swing.GroupLayout.DEFAULT_SIZE, 259,
								Short.MAX_VALUE).addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout
						.createSequentialGroup()
						.addComponent(texto,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		emo.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/icon/emo6.jpg")));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(emo)
														.addComponent(
																jPanel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(emo)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																Alignment.TRAILING)
																.addComponent(
																		jPanel3,
																		Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jPanel4,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jPanel2,
														GroupLayout.DEFAULT_SIZE,
														313, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jPanel1,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(
														jPanel1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jPanel3,
																		GroupLayout.PREFERRED_SIZE,
																		125,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		jPanel4,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		jPanel2,
																		GroupLayout.PREFERRED_SIZE,
																		212,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		game = new Ahorcado1(texto, emo, emogrande);
		restaurar_color();
	}

	private void restaurar_color() {
		Color c = new Color(240, 240, 240);
		button_A.setBackground(c);
		button_B.setBackground(c);
		button_D.setBackground(c);
		button_C.setBackground(c);
		button_E.setBackground(c);
		button_F.setBackground(c);
		button_G.setBackground(c);
		button_H.setBackground(c);
		button_I.setBackground(c);
		button_J.setBackground(c);
		button_K.setBackground(c);
		button_L.setBackground(c);
		button_M.setBackground(c);
		button_N.setBackground(c);
		button_Ñ.setBackground(c);
		button_O.setBackground(c);
		button_P.setBackground(c);
		button_Q.setBackground(c);
		button_R.setBackground(c);
		button_S.setBackground(c);
		button_T.setBackground(c);
		button_U.setBackground(c);
		button_V.setBackground(c);
		button_W.setBackground(c);
		button_X.setBackground(c);
		button_Y.setBackground(c);
		button_Z.setBackground(c);
	}

	private void button_AActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('A');
		button_A.setBackground(color);
	}

	private void button_BActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('B');
		button_B.setBackground(color);
	}

	private void button_CActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('C');
		button_C.setBackground(color);
	}

	private void button_DActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('D');
		button_D.setBackground(color);
	}

	private void button_EActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('E');
		button_E.setBackground(color);
	}

	private void button_FActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('F');
		button_F.setBackground(color);
	}

	private void button_GActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('G');
		button_G.setBackground(color);
	}

	private void button_HActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('H');
		button_H.setBackground(color);
	}

	private void button_IActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('I');
		button_I.setBackground(color);
	}

	private void button_JActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('J');
		button_J.setBackground(color);
	}

	private void button_KActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('K');
		button_K.setBackground(color);
	}

	private void button_LActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('L');
		button_L.setBackground(color);
	}

	private void button_MActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('M');
		button_M.setBackground(color);
	}

	private void button_NActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('N');
		button_N.setBackground(color);
	}

	private void button_ÑActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('Ñ');
		button_Ñ.setBackground(color);
	}

	private void button_OActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('O');
		button_O.setBackground(color);
	}

	private void button_PActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('P');
		button_P.setBackground(color);
	}

	private void button_QActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('Q');
		button_Q.setBackground(color);
	}

	private void button_RActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('R');
		button_R.setBackground(color);
	}

	private void button_SActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('S');
		button_S.setBackground(color);
	}

	private void button_TActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('T');
		button_T.setBackground(color);
	}

	private void button_UActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('U');
		button_U.setBackground(color);
	}

	private void button_VActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('V');
		button_V.setBackground(color);
	}

	private void button_WActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('W');
		button_W.setBackground(color);
	}

	private void button_XActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('X');
		button_X.setBackground(color);
	}

	private void button_YActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('Y');
		button_Y.setBackground(color);
	}

	private void button_ZActionPerformed(java.awt.event.ActionEvent evt) {
		game.evaluar('Z');
		button_Z.setBackground(color);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"PUEDE CONSEGUIRLO,\nSiga intentandolo");
	}

	/**
	 * Declaracion de variables dentro del programa.
	 */
	private javax.swing.JButton button_A;
	private javax.swing.JButton button_B;
	private javax.swing.JButton button_C;
	private javax.swing.JButton button_D;
	private javax.swing.JButton button_E;
	private javax.swing.JButton button_F;
	private javax.swing.JButton button_G;
	private javax.swing.JButton button_H;
	private javax.swing.JButton button_I;
	private javax.swing.JButton button_J;
	private javax.swing.JButton button_K;
	private javax.swing.JButton button_L;
	private javax.swing.JButton button_M;
	private javax.swing.JButton button_N;
	private javax.swing.JButton button_O;
	private javax.swing.JButton button_P;
	private javax.swing.JButton button_Q;
	private javax.swing.JButton button_R;
	private javax.swing.JButton button_S;
	private javax.swing.JButton button_T;
	private javax.swing.JButton button_U;
	private javax.swing.JButton button_V;
	private javax.swing.JButton button_W;
	private javax.swing.JButton button_X;
	private javax.swing.JButton button_Y;
	private javax.swing.JButton button_Z;
	private javax.swing.JButton button_Ñ;
	private javax.swing.JLabel emo;
	private javax.swing.JLabel emogrande;
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JTextField texto;
	private JMenuBar menuBar;
	private JMenuItem mntmMenu;
	private JMenu mnMenu;
	private JMenuItem mntmAcercaDe;

}
