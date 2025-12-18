package Back;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

public class ViaCep {

    private static final OkHttpClient http = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static ViaCEPResponse buscarCEP(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = http.newCall(request).execute()) {

                if (!response.isSuccessful() || response.body() == null) {
                    return null;
                }

                String json = response.body().string();
                return gson.fromJson(json, ViaCEPResponse.class);
            }

        } catch (Exception e) {
            return null;
        }
    }

    public static class ViaCEPResponse {
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
        private String ibge;
        private String gia;
        private String ddd;
        private String siafi;
        private boolean erro;

        public String getCep() { return cep; }
        public String getLogradouro() { return logradouro; }
        public String getComplemento() { return complemento; }
        public String getBairro() { return bairro; }
        public String getLocalidade() { return localidade; }
        public String getUf() { return uf; }
        public String getIbge() { return ibge; }
        public String getGia() { return gia; }
        public String getDdd() { return ddd; }
        public String getSiafi() { return siafi; }
        public boolean temErro() { return erro; }
    }
}
