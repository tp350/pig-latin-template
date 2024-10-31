public class Song
{
  // Private instance variables
  private String title = "Unknown";
  private String artist = "Unknown Artist";

  // Default constructor
  public Song(){} 

  // Overloaded constructor
  public Song(String artist, String title) 
  {
    // note usage of this to assign to the instance variables
    this.artist = artist;
    this.title = title;
  }

  // toString for printing the object
  public String toString()
  {
    return artist + " - " + title;
  }
  
  // Getters for getting private instance variables
  public String getTitle()
  {
    return title;
  }
  
  public String getArtist()
  {
    return artist;
  }
  
  // Setters to update instance variables
  public void setTitle(String title)
  {
      this.title = title;
  }
  
  public void setArtist(String artist)
  {
    this.artist = artist;
  }
}