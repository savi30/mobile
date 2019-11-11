package server.data;

import java.util.List;

public class Book {
    private String id;
    private String name;
    private Integer noPages;
    private Double progress;
    private List<Log> logs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoPages() {
        return noPages;
    }

    public void setNoPages(Integer noPages) {
        this.noPages = noPages;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
