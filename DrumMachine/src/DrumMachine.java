import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class DrumMachine extends JFrame{
	private final static int NUMBER_OF_BARS = 16;
	private AudioClip[] audioClips;
	private JCheckBox[] checkBoxes;
	private Timer timer;
	private int index;
	
	public DrumMachine(){
		openAudioClips();
		
		checkBoxes = new JCheckBox[12];
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, checkBoxes.length));
		for(int i = 0; i < checkBoxes.length; i++){
			checkBoxes[i] = new JCheckBox();
			panel.add(checkBoxes[i]);
		}
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		JButton buttonStart = new JButton("Start");
		panel.add(buttonStart);
		buttonStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timer.start();
			}
		});
		JButton buttonStop = new JButton("Stop");
		panel.add(buttonStop);
		buttonStop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timer.stop();
			}
		});
		timer = new Timer(100, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onTimerUpdate();
			}
		});
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void openAudioClips(){
		try {
			audioClips = new AudioClip[NUMBER_OF_BARS];
			for (int i = 0; i < audioClips.length; i++){
				audioClips[i] = new AudioClip();
				audioClips[i].open(new File("BD.wav"));
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void onTimerUpdate(){
		if (checkBoxes[index].isSelected()){
			audioClips[index].start();
		}
		index = (index + 1) % checkBoxes.length;
	}
	
	public static void main(String[]arg){
		new DrumMachine();
	}
}
