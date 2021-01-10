
package com.jreron.springhttpclient.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Stock implements Serializable
{

    public String exchange;
    public String shortname;
    public String quoteType;
    public String symbol;
    public String index;
    public Double score;
    public String typeDisp;
    public String longname;
    public Boolean isYahooFinance;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7531119152048063691L;

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
