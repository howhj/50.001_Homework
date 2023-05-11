package piano;

import javax.sound.midi.MidiUnavailableException;
import midi.Midi;
import music.Pitch;
import midi.Instrument;
import music.NoteEvent;
import java.util.ArrayList;

public class PianoMachine {
	
	private Midi midi;
	private boolean playingA = false;
	private boolean playingAx = false;
	private boolean playingB = false;
	private boolean playingC = false;
    private boolean playingCx = false;
	private boolean playingD = false;
    private boolean playingDx = false;
	private boolean playingE = false;
    private boolean playingF = false;
    private boolean playingFx = false;
	private boolean playingG = false;
    private boolean playingGx = false;
    private boolean play = false;
    private boolean stop = false;
    private Instrument instrument = Midi.DEFAULT_INSTRUMENT;
    private int shifts = 0;
    private boolean recording = false;
    private final ArrayList<NoteEvent> inputs = new ArrayList<>();
    private long reference;
    
	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
		switch (rawPitch.hashCode()) {
			case (9):
				if (!playingA) {
					playingA = true;
					play = true;
				}
                break;
			case (10):
				if (!playingAx) {
					playingAx = true;
                    play = true;
				}
                break;
            case (11):
                if (!playingB) {
                    playingB = true;
                    play = true;
                }
                break;
            case (0):
                if (!playingC) {
                    playingC = true;
                    play = true;
                }
                break;
            case (1):
                if (!playingCx) {
                    playingCx = true;
                    play = true;
                }
                break;
            case (2):
                if (!playingD) {
                    playingD = true;
                    play = true;
                }
                break;
            case (3):
                if (!playingDx) {
                    playingDx = true;
                    play = true;
                }
                break;
            case (4):
                if (!playingE) {
                    playingE = true;
                    play = true;
                }
                break;
            case (5):
                if (!playingF) {
                    playingF = true;
                    play = true;
                }
                break;
            case (6):
                if (!playingFx) {
                    playingFx = true;
                    play = true;
                }
                break;
            case (7):
                if (!playingG) {
                    playingG = true;
                    play = true;
                }
                break;
            case (8):
                if (!playingGx) {
                    playingGx = true;
                    play = true;
                }
                break;
		}

		if (play) {
            Pitch pitch = rawPitch.transpose(Pitch.OCTAVE * shifts);
            midi.beginNote(pitch.toMidiFrequency(), instrument);
            if (recording) {
                if (inputs.isEmpty()) { reference = System.currentTimeMillis(); }
                inputs.add(new NoteEvent(pitch, System.currentTimeMillis() - reference,
                        instrument, NoteEvent.Kind.start));
            }
            play = false;
        }
    }

    public void endNote(Pitch rawPitch) {
        switch (rawPitch.hashCode()) {
            case (9):
                if (playingA) {
                    playingA = false;
                    stop = true;
                }
                break;
            case (10):
                if (playingAx) {
                    playingAx = false;
                    stop = true;
                }
                break;
            case (11):
                if (playingB) {
                    playingB = false;
                    stop = true;
                }
                break;
            case (0):
                if (playingC) {
                    playingC = false;
                    stop = true;
                }
                break;
            case (1):
                if (playingCx) {
                    playingCx = false;
                    stop = true;
                }
                break;
            case (2):
                if (playingD) {
                    playingD = false;
                    stop = true;
                }
                break;
            case (3):
                if (playingDx) {
                    playingDx = false;
                    stop = true;
                }
                break;
            case (4):
                if (playingE) {
                    playingE = false;
                    stop = true;
                }
                break;
            case (5):
                if (playingF) {
                    playingF = false;
                    stop = true;
                }
                break;
            case (6):
                if (playingFx) {
                    playingFx = false;
                    stop = true;
                }
                break;
            case (7):
                if (playingG) {
                    playingG = false;
                    stop = true;
                }
                break;
            case (8):
                if (playingGx) {
                    playingGx = false;
                    stop = true;
                }
                break;
        }

        if (stop) {
            Pitch pitch = rawPitch.transpose(Pitch.OCTAVE * shifts);
            midi.endNote(pitch.toMidiFrequency(), instrument);
            if (recording) {
                inputs.add(new NoteEvent(pitch, System.currentTimeMillis() - reference,
                        instrument, NoteEvent.Kind.stop));
            }
            stop = false;
        }
    }

    public void changeInstrument() {
        instrument = instrument.next();
    }

    public void shiftUp() {
        if (shifts < 2) { shifts += 1; }
    }

    public void shiftDown() {
        if (shifts > -2) { shifts -= 1; }
    }

    public boolean toggleRecording() {
        if (!recording) {
            recording = true;
            inputs.clear();
        }
        else { recording = false; }
    	return recording;
    }

    public void playback() {    	
         if (inputs.isEmpty()) { return; }

         long ref = System.currentTimeMillis();
         long time = ref;
         for (NoteEvent ne : inputs) {
             long next = ne.getTime() + ref;
             while (time < next) {
                 try { Thread.sleep((int)(next - time)); }
                 catch (InterruptedException e) {}
                 time = System.currentTimeMillis();
             }
             if (ne.getKind() == NoteEvent.Kind.start) {
                 midi.beginNote(ne.getPitch().toMidiFrequency(), ne.getInstr());
             }
             else if (ne.getKind() == NoteEvent.Kind.stop) {
                 midi.endNote(ne.getPitch().toMidiFrequency(), ne.getInstr());
             }
         }
    }

}
