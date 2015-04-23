import org.jfugue.*;

/**
 * @author Fin Malone
 * @version 04/23/2015
 * 
 * The class that creates all the necessary notes and pattern strings that can be added into the
 * song using the MusicPlayer class.
 */
public class MusicCreator {
    /**
     * @return  Returns the bass pattern used in the intro and verse of the song.
     */
    public Pattern synthBass()
    {
        Pattern bass1 = new Pattern("V0 KEmin T[80] I[SYNTH_BASS_1]");
        bass1.add("| E3i E2i E2i E2i Ri E2i E2i E2i |");
        return bass1;
    }

    /**
     * @return  Returns the guitar pattern used in the verse of the song.
     */
    public Pattern guitar()
    {
        Pattern guitar1 = new Pattern("V3 KEmin T[80] I[OVERDRIVEN_GUITAR]");
        guitar1.add("| RW ",13);
        guitar1.add("| Ri E4q.hi+B4q.hi+E5q.hi D5q.h+A5q.h+D6q.h+F6q.h | E5i E4q.h+B4q.h+E5q.h | ");
        guitar1.add("E5i D5q.h+A5q.h+D6q.h+F6q.h | ");
        return guitar1;
    }

    /**
     * @return  Returns the strings pattern used in the intro and verse of the song.
     */
    public Pattern synthStrings()
    {
        Pattern synth1 = new Pattern("V1 KEmin T[80] I[SYNTH_STRINGS_1]");
        synth1.add("| Rh Ri B4q.+E5q. | B4h+E5h  Rh |");
        return synth1;
    }

    /**
     * @return  Returns the synth melody (originally vocals) pattern used in the verse of
     *          the song.
     */
    public Pattern synthMelody()
    {
        Pattern voxMelody1 = new Pattern("V2 KEmin T[80] I[SYNTH_VOICE]");
        voxMelody1.add("| Rw | Rw | Rw | Rw | ");
        voxMelody1.add("Rh Ri B5s B5s D6i C#6s B5s- | B5q Rq Ri B5s B5s D6i C#6i | B5q ");
        voxMelody1.add("Rq Rq D6s D6s C#6s C#6s | B5s E5i. Rq Rs E5s E5s E5s A5i G5i | E5q");
        voxMelody1.add(" Rq Ri D6s D6s E6i E6s D6s | E6q Rq Rs E6s E6s B6s B6s A6s G6s A6s- | A6q");
        voxMelody1.add(" Rq Ri B6s B6s B6i A6s G6s | B6q Rq Rs E6s E6s E6s B6i A6i | A6q");
        voxMelody1.add(" Rq Rs A6s B6i D7i C#7s B6i- | B6q Rq Rs A6s B6i D7i C#7s B6s | B6q");
        voxMelody1.add(" Rq Rs A6s B6i D7i C#7s B6s | B6q Rq Ri B6s B6s D7s D7s C#i | B6q");
        voxMelody1.add(" Rq Ri E6s E6s A6s G6i. | G6i Ri B5q Ri B5s B5s D6s E6s E6i | E6q");
        return voxMelody1;
    }
}