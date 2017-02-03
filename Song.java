import java.util.Comparator;


public class Song implements Comparable<Song>, Comparator <Song>{
	private String title;
	private String artist;
	private String key;
	private int play_count;
	
	public Song(String title, String artist, String key, int play_count) {
		this.title = title;
		this.artist = artist;
		this.key = key;
		this.play_count = play_count;
	}
	
	public void incrementPlayCount(){
		this.play_count++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPlay_count() {
		return play_count;
	}

	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}

	@Override
	public String toString() {
		return title + " by " + artist + ". Play Count = " + play_count;
	}

	@Override
	public int compareTo(Song o) {
		Song s = (Song)o;
		if(this.play_count > s.play_count)
			return 1;
		else if(this.play_count == s.play_count)
			return 0;
		else
			return -1;
	}

	@Override
	public int compare(Song s1, Song s2) {
		// if they have equal play counts, sort alphabetically
				if(s1.getPlay_count() == s2.getPlay_count())
					return s1.getTitle().compareTo(s2.getTitle());
				// else sort by play count
				else
					return Integer.compare(s1.getPlay_count(), s2.getPlay_count());
	}
	
	
}
