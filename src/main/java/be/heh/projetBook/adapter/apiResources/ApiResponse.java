package be.heh.projetBook.adapter.apiResources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {
    @JsonProperty("docs")
    private List<ApiDocs> docs;

    public List<ApiDocs> getDocs() {
        return docs;
    }
    public void setDocs(List<ApiDocs> docs) {
        this.docs = docs;
    }
}
