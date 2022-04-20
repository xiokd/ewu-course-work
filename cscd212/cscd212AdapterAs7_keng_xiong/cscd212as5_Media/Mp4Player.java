package cscd212as5_Media;

public class Mp4Player implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		// Empty
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing Mp4 file. Name: " + fileName);
	}
}
