package mylab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
	protected int fileSize;
	protected int volume;

	public MP3(String title, String artist, String format, int fileSize) {
		this(title, artist, format, fileSize, 5);
	}

	public MP3(String title, String artist, String format, int fileSize, int volume) {
		super(title, artist, format);
		this.fileSize = fileSize;
		this.volume = volume;
	}

	@Override
	public void play() {
		super.play();
		System.out.println("���� ����: " + volume);
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("���� ũ��: " + fileSize + "MB");
	}

	@Override
	public void setVolume(int level) {
		this.volume = level;
		System.out.println("������ " + level + "�� �����Ǿ����ϴ�.");
	}

	@Override
	public void stop() {
		System.out.println("MP3 ����� �����Ǿ����ϴ�. ");
	}

}
