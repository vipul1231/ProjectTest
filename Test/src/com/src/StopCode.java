package com.src;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StopCode {
    private Integer stopCodeID = null;
    private String stopCodeDescription = null;
    private Integer stopCodePriority = null;

    public StopCode() {
    }

    @JsonProperty("stopCodeID")
    public Integer getStopCodeID() {
        return this.stopCodeID;
    }

    public void setStopCodeID(Integer stopCodeID) {
        this.stopCodeID = stopCodeID;
    }

    @JsonProperty("stopCodeDescription")
    public String getStopCodeDescription() {
        return this.stopCodeDescription;
    }

    public void setStopCodeDescription(String stopCodeDescription) {
        this.stopCodeDescription = stopCodeDescription;
    }

    @JsonProperty("stopCodePriority")
    public Integer getStopCodePriority() {
        return this.stopCodePriority;
    }

    public void setStopCodePriority(Integer stopCodePriority) {
        this.stopCodePriority = stopCodePriority;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StopCode {\n");
        sb.append("  stopCodeID: ").append(this.stopCodeID).append("\n");
        sb.append("  stopCodeDescription: ").append(this.stopCodeDescription).append("\n");
        sb.append("  stopCodePriority: ").append(this.stopCodePriority).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}

