package JEntity;

import java.security.Timestamp;

public class JBlogEntity implements java.io.Serializable {
    private String Name;
    private String Content;
    private String CreateTime;
    private Long ID;

    public JBlogEntity(){}


    public String getName(){
        return Name;
    }
    public String getContent(){
        return Content;
    }
    public String getCreateTime(){
        return CreateTime;
    }
    public Long getID(){
        return ID;
    }

    public void setName(String Name){
        this.Name=Name;
    }
    public void setContent(String Content){
        this.Content=Content;
    }
    public void setCreateTime(String CreateTime){
        this.CreateTime=CreateTime;
    }
    public void setID(Long  ID){
        this.ID=ID;
    }

}
