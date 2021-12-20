import cscd212as5_Media.*;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3"); // Plays mp3
		audioPlayer.play("mp4", "alone.mp4"); // Plays mp4
		audioPlayer.play("vlc", "far far away.vlc"); // Plays vlc
		audioPlayer.play("avi", "mind me.avi"); // Does not play anything, avi not supported

	}

}
