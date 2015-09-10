package com.holiday;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * Created by Development on 4/12/2015.
 */
public class ElasticSearchClient {

    public static  Client createClient()
    {
         Client client=null;
            //Try starting search client at context loading
            try
            {
                Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name","accommodation").build();
                TransportClient transportClient = new TransportClient(settings);
                transportClient = transportClient.addTransportAddress(new InetSocketTransportAddress("192.168.225.128", 9300));
                if(transportClient.connectedNodes().size() == 0)
                {
                    System.out.print("There are no active nodes available for the transport, it will be automatically added once nodes are live!");
                }
                client = transportClient;
            }
            catch(Exception ex)
            {
                //ignore any exception, dont want to stop context loading

            }
        return client;
    }
}
