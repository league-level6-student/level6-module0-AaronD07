package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import com.sun.tools.javac.util.DefinedBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

    NewsApi newsApi;


    @Mock
    WebClient client;
    @Mock
    RequestHeadersSpec headersSpec;
    @Mock
    RequestHeadersUriSpec headersUriSpec;
    @Mock
    ResponseSpec responseSpec;
    @Mock
    UriBuilder uriBuild;
    @Mock
    Mono<ApiExampleWrapper> mono;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        newsApi = new NewsApi();
        newsApi.setWebClient(client);

    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
String topic = "pasta";
ApiExampleWrapper expected = new ApiExampleWrapper();
        when(client.get()).thenReturn(headersUriSpec);
        when(headersUriSpec.uri((Function<UriBuilder, URI>) any())).thenReturn(headersSpec);
        when(headersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(ApiExampleWrapper.class)).thenReturn(mono);
       when(mono.block()).thenReturn(expected);
        //when
        ApiExampleWrapper actual = newsApi.getNewsStoryByTopic(topic);

        //then
        assertEquals(expected, actual);


    }

    @Test
    void itShouldFindStory(){
        //given
String topic = "pasta";

        //when

        //then
    }


}