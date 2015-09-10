package com.holiday;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

import java.util.List;

public class Main {

    //    private String searchServerClusterNodes = "localhost:9300";
    private String searchServerClusterName = "jaidev";


    public static void main(String[] args) {
	// write your code here
        Search search=new SearchImpl();
      List s=search.search();

    }




}
