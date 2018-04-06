package com.src;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyStopCodes {
    private Site site = null;
    private List<StopCode> code = new ArrayList();

    public PropertyStopCodes() {
    }

    @JsonProperty("site")
    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @JsonProperty("code")
    public List<StopCode> getCode() {
        return this.code;
    }

    public void setCode(List<StopCode> code) {
        this.code = code;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PropertyStopCodes {\n");
        sb.append("  site: ").append(this.site).append("\n");
        sb.append("  code: ").append(this.code).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}

