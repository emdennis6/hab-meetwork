package hi.meetwork;

/**
 * Created by jib on 2/6/2016.
 */
public class Event {
    private String Topic;
    private long TimeStamp;
    private String Description;

    public Event(String Topic, long TimeStamp, String Description){
        this.Topic = Topic;
        this.TimeStamp = TimeStamp;
        this.Description = Description;
    }

    public String getTopic(){return Topic;}

    public String getDescription(){return Description;}

    public void setTopic(String Topic){this.Topic = Topic;}

    public void setDescription(String Description){this.Description = Description;}


    public void EditEvent(){

    };




}
