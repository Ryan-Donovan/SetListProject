import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class SetListTest {

/** METHOD TO SEARCH FOR SONGS FOUND IN THE  SETLIST FILE IN THE MASTER LIST **/
    
    public static Song SequentialSearch(String s, List<Song> songs) {
    	for(int i = 0; i < songs.size(); i++){
    		if(songs.get(i).getTitle().equals(s))
    			return songs.get(i);
    	}
    	return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
    	
    	 ArrayList<Song> Songs = new ArrayList<Song>();
    	 ArrayList<Song> Check = new ArrayList<Song>();
    	
 /** READ THE MASTER SETLIST **/
    	
    	File file1 = new File("Songs.csv");
        Scanner scanner1 = new Scanner(file1);
        scanner1.useDelimiter(",");
/** PARSE THE MASTER SETLIST SO THAT WE FILL THE ARRAYLIST OF SONGS WITH THE SONGS **/     
        while(scanner1.hasNext()){
        	String [] thisSong = scanner1.nextLine().split(",");
        	Song newSong = new Song(thisSong[0], thisSong[1], thisSong[2], Integer.parseInt(thisSong[3]));
        	Songs.add(newSong);    
        }
        
        for(int i = 0; i<Songs.size();i++) {
        	Check.add(Songs.get(i));
        }
        
        
        scanner1.close();
/** READ THE TEXT FILE SETLISTS AND INCREMENT PLAY COUNT ACCORDINGLY **/
        ArrayList<File> myFiles = new ArrayList<File>();
        File file2 = new File("Crozet.txt");
        File file3 = new File("PhiDeltParty.txt");
        File file4 = new File("ROTCBall.txt");
        myFiles.add(file2);
        myFiles.add(file3);
        myFiles.add(file4);
        
        for(File f:myFiles){
        	Scanner scanner2 = new Scanner(f);
        
        	while(scanner2.hasNext()){
        		String s = scanner2.nextLine();
        		if(SequentialSearch(s,Songs) != null)
        			SequentialSearch(s,Songs).incrementPlayCount();		
        	}
        scanner2.close();
        }
        
        Collections.sort(Check, new CmpByPlayCount());
        for(Song s : Check) {
        	System.out.println(s.toString());
        }
        
    }

 


}
