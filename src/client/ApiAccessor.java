package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.databind.ObjectMapper;

import apimodels.AuthResponse;
import apimodels.DebugRequest;
import apimodels.DebugResponse;
import apimodels.InitialMessageRequest;
import apimodels.MessageRequest;
import apimodels.MessageResponse;

public class ApiAccessor {

	private String s = "https://teaching.its.uni-luebeck.de/ks/signal/api/";
	byte[] newRatchetPublicKey = null;
	
	public AuthResponse authenticate(String name) throws ClientProtocolException, IOException {
		// post request
		String response = post(s + "auth", "{\"name\":\"" + name + "\"}");

		// process response and create message response
		return new ObjectMapper().readValue(response, AuthResponse.class);
	}

	public MessageResponse firstMessage(InitialMessageRequest firstMessageRequest)
			throws ClientProtocolException, IOException {
		// post request
		String response = post(s + "init", firstMessageRequest.toString());
		
		// process response and create message response
		return new ObjectMapper().readValue(response, MessageResponse.class);
	}

	public MessageResponse message(MessageRequest messageRequest) throws ClientProtocolException, IOException {
		// post request
		String response = post(s + "message", messageRequest.toString());

		// process response and create message response
		return new ObjectMapper().readValue(response, MessageResponse.class);
	}

	public DebugResponse message(DebugRequest debugRequest) throws ClientProtocolException, IOException {
		// post request
		String response = post(s + "debug", debugRequest.toString());

		// process response and create message response
		return new ObjectMapper().readValue(response, DebugResponse.class);
	}

	private String post(String uri, String data) throws ClientProtocolException, IOException {
		HttpURLConnection con = null;

		byte[] postData = data.getBytes(StandardCharsets.UTF_8);
		String result;

		try {
			URL myurl = new URL(uri);
			con = (HttpURLConnection) myurl.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Java client");
			con.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;
			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String line;
				content = new StringBuilder();

				while ((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}
			result = content.toString();
		} finally {
			con.disconnect();
		}
		return result;
	}

}
