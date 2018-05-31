package com.psicovirtual.estandar.modelo.servicios;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.IOException;

public class consumoSMS {

	public void consumoServioSMS() throws IOException {

		System.out.println("init");

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n \"from\":\"InfoSMS\",\r\n \"to\":\"573108488989\",\r\n \"text\":\"My first Infobip SMS\"\r\n}");

		String has = Base64.encode(("mslmsc" + ":" + "M5lmsc1204.").getBytes());
		String url = "https://api.infobip.com/sms/1/text/single";
		Request request = new Request.Builder().url(url).post(body).addHeader("authorization", "Basic " + has)
				.addHeader("content-type", "application/json").addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		System.out.println("Respuesta " + response.body().string());
		System.out.println("test");
	}

	public static void main(String[] args) throws Exception {
		consumoSMS a = new consumoSMS();
		a.consumoServioSMS();

	}
	
	
	
	public  void enviaCorreo() {
		
		/*  ContentType PLAIN_UTF8 = ContentType.create("text/plain", StandardCharsets.UTF_8);

	        HttpClient httpClient = HttpClients.custom()
	                .setConnectionManager(new PoolingHttpClientConnectionManager())
	                .build();

	        HttpPost httpPost = new HttpPost("https://api.infobip.com/email/1/send");
	        httpPost.setHeader("authorization", "Basic YXJhamhhbnNhOmF4ZGNmcnQyMz");

	        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
	        entityBuilder.addPart("from", new StringBody("Jane Doe <jane.doe@somecompany.com>", PLAIN_UTF8));
	        entityBuilder.addPart("to", new StringBody("john.smith@somedomain.com", PLAIN_UTF8));
	        entityBuilder.addPart("subject", new StringBody("Mail subject text", PLAIN_UTF8));
	        entityBuilder.addPart("text", new StringBody("Mail body text", PLAIN_UTF8));

	        httpPost.setEntity(entityBuilder.build());
	        HttpResponse httpResponse = httpClient.execute(httpPost);
		*/
		
	}
	

}
