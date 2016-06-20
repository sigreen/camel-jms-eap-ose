package org.jboss.fuse.examples.aggregate;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class DBAggregationStrategy implements AggregationStrategy {
 
    public Exchange aggregate(Exchange original, Exchange resource) {
        String originalBody = (String) original.getIn().getBody();
        //List<?> resourceResponse = (List<?>) resource.getIn().getBody();
        // and each row in the list is a Map
       // Map<?, ?> row = resourceResponse.get(0);   
        String firstname = "";
        String lastname = "";
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = resource.getIn().getBody(List.class);
        for (Map<String, Object> row : rows) {
            firstname = (String) row.get("CONTACT_FIRSTNAME");
            lastname = (String) row.get("CONTACT_LASTNAME");
        }

        String mergeResult = originalBody.replace("FirstName=\"\"","FirstName=\"" + firstname + "\"");
        mergeResult = mergeResult.replace("LastName=\"\"","LastName=\"" + lastname + "\"");
        if (original.getPattern().isOutCapable()) {
            original.getOut().setBody(mergeResult);
        } else {
            original.getIn().setBody(mergeResult);
        }
        return original;
    }
     
}