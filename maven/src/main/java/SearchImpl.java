package com.holiday;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import javax.swing.event.CaretListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Development on 4/12/2015.
 */
public class SearchImpl implements Search {
    @Override
    public List search() {

        Client client=ElasticSearchClient.createClient();
        XContentBuilder builder = null;
        try {
            builder = XContentFactory.jsonBuilder();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            builder.startObject()
            .field("user", "kimchy")
            .field("postDate", new Date())
            .field("message", "trying out Elasticsearch")
            .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                    .setSource(builder
                                    .startObject()
                                    .field("user", "kimchy")
                                    .field("postDate", new Date())
                                    .field("message", "trying out Elasticsearch")
                                    .endObject()
                    )
                    .execute()
                    .actionGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
