package consultant.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel",
//        chatMemory = "chatMemory",//配置绘画对象
        chatMemoryProvider = "chatMemoryProvider",//配置会话提供者对象
        contentRetriever = "contentRetriever",//配置向量数据库检索对象
        tools = "reservationTool"
)
public interface ConsultantService {
    //用于聊天的方法
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryID , @UserMessage String message);

}