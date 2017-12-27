package com.getSearchData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import com.config.SolrConnection;

public class SearchData {

	public List<HashMap<String, String>> suggestSpell(String text) {
		SolrConnection solrConnection = new SolrConnection();
		HttpSolrClient client = solrConnection.getSolrConnection();

		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/select");

	//	HashMap<String, List<HashMap<String, String>>> map = new HashMap<>();
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		query.add("q", text);
		try {
			QueryResponse response = client.query(query);
			dataList = getData(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}

	List<HashMap<String, String>> getData(QueryResponse response) {
		
		SolrDocumentList list = response.getResults();
		HashMap<String, List<HashMap<String, String>>> map = new HashMap<>();
		
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		
		for (SolrDocument doc : list) {
			HashMap<String, String> dataMap = new HashMap<>();
			for (String str : doc.getFieldNames()) {
				dataMap.put(str, doc.getFieldValue(str).toString());;
			}
			dataList.add(dataMap);
			//System.out.println();
		}
		map.put("data", dataList);
		return dataList;
	}
}
