package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class ExitPreProceso extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public ExitPreProceso() {
		
		System.out.println("Hilo de la instancia ExitPreProceso: " + Thread.currentThread().getName());
		setSize(300,150);
		setTitle("Cerrando la aplicación");
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JLabel resultLabel = new JLabel("Esperando el resultado");
		JProgressBar barraProgreso = new JProgressBar(1, 10);
		
		mainPanel.add(new JLabel("label de prueba"), BorderLayout.CENTER);
		mainPanel.add(resultLabel, BorderLayout.NORTH);
		mainPanel.add(barraProgreso, BorderLayout.SOUTH);
		add(mainPanel);
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setLocationByPlatform(true);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//Instancia swingWorker.
		
		SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {

			@Override
			protected String doInBackground() throws Exception {
				System.out.println("el worker esta en el hilo: " + Thread.currentThread().getName());
				for (int i = 0; i < 10; i++) {
					System.out.println("procesando el valor: "+ i);
					publish(i+1);
					TimeUnit.SECONDS.sleep(1);
				}
				return "Valor string devuelto";
			}

			@Override
			protected void process(List<Integer> chunks) {

				barraProgreso.setValue(chunks.get(0));
			}

			@Override
			protected void done() {
				resultLabel.setText("Finalizado.. el hilo del worker");
				//Tomando el tiempo de alguna tarea.
				//long tIncio, tFin;
				//tIncio = System.currentTimeMillis();
				Timer timer = new Timer(2500, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("el hilo esta en: " + Thread.currentThread().getName());
						System.out.println("espernado 2500 millis. para finalizar la app.");
						try { Thread.sleep(2500); } catch(InterruptedException ex) {};
						System.out.println("App finalizada.!");
						dispose();
						System.exit(0);
					}
				});
				timer.setRepeats(false);
				timer.start();
				//dispose();
				//tFin = System.currentTimeMillis();
				//System.out.println("El tiempo fue de: " + (tFin - tIncio) + " miliseconds.");
				//System.exit(1);
			}
			
		};
		
		worker.execute();
	
		
	}

}
