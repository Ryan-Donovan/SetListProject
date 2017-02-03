import java.util.Comparator;


public class CmpByPlayCount implements Comparator<Song> {

	/** Override of Compare method to sort by play count **/
	@Override
	public int compare(Song s1, Song s2) {
		// if they have equal play counts, sort alphabetically
		if(s1.getPlay_count() == s2.getPlay_count())
			return s1.getTitle().compareTo(s2.getTitle());
		// else sort by play count
		else{
			if(s1.getPlay_count()>s2.getPlay_count())
				return -1;
			else if(s1.getPlay_count()<s2.getPlay_count())
				return 1;
			else return 0;
		}
	}
}

