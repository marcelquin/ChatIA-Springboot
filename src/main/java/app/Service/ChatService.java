package app.Service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    private final ChatLanguageModel model;

    public ChatService(ChatLanguageModel model, Environment env) {
        this.model = model;
    }


    public String Chat(String mensagem)
    {
        try
        {
            PromptTemplate template = PromptTemplate.from("Você é um especialista em docker e devops e deve resolver e responder a pergunta: {question}");
            Map<String, Object> mapa = new HashMap<String, Object>();
            mapa.put("question", mensagem);
            Prompt prompt = template.apply(mapa);
            return model.generate(prompt.text());
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
}
