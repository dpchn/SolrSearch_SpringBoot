
package com.dataImport;

import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.common.params.ModifiableSolrParams;

import com.solrConfig.SolrServer;

public class Indexing {
	public void FullImport(HttpSolrClient client) {
		ModifiableSolrParams params = new ModifiableSolrParams();

		try {

			params.set("qt", "/dataimport");
			params.set("command", "full-import");

			client.query(params);

			System.out.println("Succesfully full import.....");
			client.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DeltaImport(HttpSolrClient client) {
		
		ModifiableSolrParams params = new ModifiableSolrParams();
		System.out.println("Deleta import....");
		params.set("qt", "/dataimport");
		params.set("command", "delta-import");
		try {
			client.query(params);
			System.out.println("Delta import Done....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


