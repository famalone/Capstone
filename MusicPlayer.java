import org.jfugue.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Fin Malone
 * 04/23/2015
 * Implements a GUI 
 */
public class MusicPlayer
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 100;

    private JFrame frame;
    private JPanel panel;
    private JButton guitar, bass, strings, melody, play;
    private JLabel label;

    private MusicCreator create;
    private Pattern intro, verse, jukebox;

    public MusicPlayer()
    {
        jukebox = new Pattern("KEmin T[80]");
        intro = new Pattern("KEmin T[80]");
        verse = new Pattern("KEmin T[80]");
        create = new MusicCreator();

        frame = new JFrame();
        panel = new JPanel();
        
        guitar = new JButton("guitar");
        panel.add(guitar);

        bass = new JButton("bass");
        panel.add(bass);

        strings = new JButton("strings");
        panel.add(strings);

        melody = new JButton("melody");
        panel.add(melody);

        play = new JButton("play");
        panel.add(play);

        label = new JLabel("ENJOY!!!!!");
        panel.add(label);

        frame.add(panel);

        ActionListener listener = new ClickListener();
        guitar.addActionListener(listener);
        bass.addActionListener(listener);
        strings.addActionListener(listener);
        melody.addActionListener(listener);
        play.addActionListener(listener);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getActionCommand().equals("guitar"))
            {
                verse.add(create.guitar());
            }
            if(event.getActionCommand().equals("bass"))
            {
                intro.add(create.synthBass(),4);
                verse.add(create.synthBass(),14);
            }
            if(event.getActionCommand().equals("strings"))
            {
                intro.add(create.synthStrings(),2);
                verse.add(create.synthStrings(),7);
            }
            if(event.getActionCommand().equals("melody"))
            {
                verse.add(create.synthMelody());
            }
            if(event.getActionCommand().equals("play"))
            {
                jukebox.add(intro);
                jukebox.add(verse);
                
                Player player = new Player();
                player.play(jukebox);
            }
        }
    }

    public static void main(String[] args)
    {
        MusicPlayer viewer = new MusicPlayer();
    }
}
