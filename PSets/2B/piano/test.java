package piano;

import javax.sound.midi.MidiUnavailableException;
import midi.*;
import music.*;

public class test {

    public void testing() {
        try {
            Midi midi = Midi.getInstance();
            midi.clearHistory();
            PianoMachine pm = new PianoMachine();

            /*pm.beginNote(new Pitch(0));
            Midi.rest(10);
            pm.endNote(new Pitch(0));
            pm.changeInstrument();
            Midi.rest(10);
            pm.changeInstrument();
            pm.beginNote(new Pitch(2));
            Midi.rest(10);
            pm.endNote(new Pitch(2));
            System.out.println(midi.history());
            midi.clearHistory();

            pm.shiftUp();
            pm.beginNote(new Pitch(2));
            Midi.rest(10);
            pm.endNote(new Pitch(2));
            pm.shiftDown();
            System.out.println(midi.history());
            midi.clearHistory();*/

            pm.toggleRecording();
            pm.beginNote(new Pitch(3));
            pm.beginNote(new Pitch(5));
            Midi.rest(10);
            pm.endNote(new Pitch(3));
            pm.endNote(new Pitch(5));
            pm.toggleRecording();
            System.out.println(midi.history());
            midi.clearHistory();

            Midi.rest(100);

            Midi.rest(10);
            pm.playback();
            Midi.rest(10);
            System.out.println(midi.history());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
}
