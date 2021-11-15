package main.model;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class DiaryEntryData {

    private SimpleStringProperty title = new SimpleStringProperty();
    private Date entryIssueTime;

    public DiaryEntryData(String title, Date entryIssueTime) {
        this.title = new SimpleStringProperty(title);
        this.entryIssueTime = entryIssueTime;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(SimpleStringProperty title) {
        this.title = title;
    }

    public Date getEntryIssueTime() {
        return entryIssueTime;
    }

    public void setEntryIssueTime(Date entryIssueTime) {
        this.entryIssueTime = entryIssueTime;
    }

}
