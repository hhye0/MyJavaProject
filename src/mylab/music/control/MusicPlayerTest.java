package mylab.music.control;

import mylab.music.entity.MP3;
import mylab.music.entity.MusicMedia;
import mylab.music.entity.Playable;
import mylab.music.entity.Vinyl;

public class MusicPlayerTest {

	public static void main(String[] args) {
		System.out.println("=== ���� ��� �ý��� �׽�Ʈ ===");
		
		System.out.println("--- MP3 �׽�Ʈ ---");
		MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 3);
		mp3.displayInfo();
		mp3.play();
		mp3.setVolume(8);
		mp3.play();
		mp3.stop();
		
		System.out.println("\n--- Vinyl �׽�Ʈ ---");
		Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
		vinyl.displayInfo();
		vinyl.play();
		vinyl.clean();
		
		System.out.println("\n--- �پ缺 �׽�Ʈ ---");
		MusicMedia media = new MP3("Butter", "BTS", "MP3", 5);
		media.displayInfo();
		media.play();
		
		System.out.println("\n--- ĳ���� �׽�Ʈ ---");
		if (media instanceof Playable) {
			Playable playable = (Playable) media;
			playable.setVolume(3);
			media.play();
			playable.setVolume(7);
			playable.stop();
			
		}
		

	}

}
