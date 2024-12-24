package com.library.management.services.google.books.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.models.google.books.api.BookApi;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookApiService {
    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes?q=intitle:";

    public List<BookApi> searchBooks(String title) throws Exception {
        // Construir la URL con el título codificado
        String apiUrl = GOOGLE_BOOKS_API_URL + title.replace(" ", "+");

        // Hacer la petición HTTP
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Leer la respuesta
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Procesar el JSON y mapear los libros
        return parseBooksJson(response.toString());
    }

    private List<BookApi> parseBooksJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        List<BookApi> books = new ArrayList<>();

        // Recorrer cada elemento en "items"
        if (rootNode.has("items")) {
            for (JsonNode item : rootNode.get("items")) {
                JsonNode volumeInfo = item.get("volumeInfo");

                BookApi book = new BookApi();
                book.setTitle(volumeInfo.has("title") ? volumeInfo.get("title").asText() : null);
                book.setPublisher(volumeInfo.has("publisher") ? volumeInfo.get("publisher").asText() : null);
                book.setPublishedDate(volumeInfo.has("publishedDate") ? volumeInfo.get("publishedDate").asText() : null);
                book.setDescription(volumeInfo.has("description") ? volumeInfo.get("description").asText() : null);
                book.setPageCount(volumeInfo.has("pageCount") ? volumeInfo.get("pageCount").asInt() : 0);
                book.setCategories(volumeInfo.has("categories")
                        ? mapper.convertValue(volumeInfo.get("categories"), List.class)
                        : null);
                book.setLanguage(volumeInfo.has("language") ? volumeInfo.get("language").asText() : null);

                // Obtener la URL de la miniatura
                if (volumeInfo.has("imageLinks") && volumeInfo.get("imageLinks").has("thumbnail")) {
                    book.setThumbnailUrl(volumeInfo.get("imageLinks").get("thumbnail").asText());
                }

                // Obtener la lista de autores
                if (volumeInfo.has("authors")) {
                    book.setAuthors(mapper.convertValue(volumeInfo.get("authors"), List.class));
                }

                books.add(book);
            }
        }

        return books;
    }
}