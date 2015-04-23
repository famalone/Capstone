import org.jfugue.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author Fin Malone
 * @version 04/23/2015
 * 
 * Implements a GUI interface that allows a user to select seperate instruments within the song
 * Jukebox Hero (Foreigner). The user can play the song with the selected instruments up until
 * the second verse. The melody has a slight delay (unnavoidable) unfortunately.
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
    /**
     * Initiates the GUI interface and its widgets and sets ActionListeners to them.
     * Also assigns the different patterns within the song to have the correct key signature
     * and tempo.
     */
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
    /**
     * This class determines the reactions to all the seperate buttons in the GUI and allows
     * the user to add instrument tracks.
     * Listens for when the buttons are clicked and called upon.
     */
    public class ClickListener implements ActionListener
    {
        /**
         * Adds the seperate instruments to the Intro, Verse, or both when a button is clicked.
         * When the play button is clicked it creates a Player object and plays the song
         * "jukebox".
         * 
         * @pre     The song must have at least one instrument added to it before the play
         *          button is clicked.
         *          
         * @param   event   an ActionEvent object aiding in listening for the button commands.
         */
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
    /**
     * Displays the GUI when called upon (the method that must be called to start the program).
     */
    public static void main(String[] args)
    {
        MusicPlayer viewer = new MusicPlayer();
    }
}
