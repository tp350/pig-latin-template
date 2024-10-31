import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class SongImporter
{
    // SongImporter does not store any data, use "static"
    // This method opens the file given by the parameter filename.
    // Then it reads the data and breaks the lines up based on commas into a series of fields.
    // Those fields are then used to create Song objects
    public static ArrayList<Song> importSongsFromCSV(String filename)
    {
        ArrayList<Song> songs = new ArrayList<Song>();
        int lineNumber = 0;

        // The code in this "try" block will run. Any errors will get handled by the "catch" below. 
        try {
            // Create a File object from the filename
            File file = new File(filename);
            
            // Create a Scanner object, this will read from the file.
            Scanner csv = new Scanner(file);

            // First line is a header - print it to see what it looks like.
            // artist_name, track_name, release_date, genre, len, shake the audience, obscene, danceability, loudness, topic
            String headerFields = csv.nextLine();
            System.out.println("Header fields: " + headerFields);

            // This while loop will loop until there are no more lines left in the CSV file.
            while (csv.hasNextLine()) 
            {
                lineNumber++; // Keep track of line numbers to make inspection of data errors simpler.

                // Limit to 30 lines for testing (remove when you are testing real files)
                if (lineNumber > 30)
                {
                    break;
                }

                // Read one line from the CSV file and store it in the variable "line"
                String line = csv.nextLine();

                // The string is then split on each comma into an array of fields.
                String[] fields = line.split(",");

                // Each field is given a name to simply their usage in constructing songs. 
                String artistName = fields[0];
                String trackName = fields[1];
                String releaseDate = fields[2];
                String genre = fields[3];
                String length = fields[4];
                String shakeTheAudience = fields[5];
                String obscene = fields[6];
                String danceability = fields[7];
                String loudness = fields[8];
                String topic = fields[9];

                // Debug print
                //System.out.println("artist: " + artist + " length: " + length + "topic: " + topic);

                // Replace the next line with your song constructor
                Song song = new Song(artistName, trackName); // code to construct a song object

                // Add the song object to the data output. (Leave alone!~)
                songs.add(song);
            }
            csv.close();
        } catch (Exception ex) {
            // If there is an error, this code will run
            System.out.println("Error on line: " + lineNumber);
            ex.printStackTrace();
        }
        return songs;
    }
}