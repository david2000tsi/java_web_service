package com.app.webservice.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.webservice.controller.Utils;

@Controller
public class CorreiosController {
	private static final String urlApi = "https://viacep.com.br/ws/%s/json/";
	private static final int cepLength = 8;

	private String getContentByCep(String cep) {
		String cepStr = "";
		try {
			if(cep.length() != cepLength || !Utils.isValidNumber(cep)) {
				System.out.println("Invalid CEP: [" + cep + "]");
				return Utils.getJsonResponse(-1, "error", "invalid cep");
			}

			String urlFinal = String.format(urlApi, cep);
			URL urlObj = new URL(urlFinal);
			HttpURLConnection  conn = (HttpURLConnection ) urlObj.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed : HTTP Error code : " + conn.getResponseCode());
                return Utils.getJsonResponse(-1, "error", "bad response code (" + conn.getResponseCode() + ")");
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                cepStr += output;
            }
            conn.disconnect();
		}catch (Exception e) {
			System.out.println("Error while get CEP data: [" + e.getMessage() + "]");
			return Utils.getJsonResponse(-1, "error", "cep data error");
		}
		
		return cepStr;
	}
	
	@RequestMapping(value="/getcepinfo/{cep}")
	@ResponseBody
	public String getCepInfo(@PathVariable("cep") String cep) {
		return getContentByCep(cep);
	}
}
