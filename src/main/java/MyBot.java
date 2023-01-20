import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class MyBot {
    public static void main(String[] args) {
        DiscordClient.create("MTA2NTc3MzQ3Mzk1NzQyNTE1Mw.GnvTL3.vJuo3mbMCnVNr8uRDyBQUyr-4FUS4vVnxvc93Y")
                .withGateway(client -> client.on(MessageCreateEvent.class, event -> {
                    Message message = event.getMessage();

                    if (message.getContent().equalsIgnoreCase("!hello")) {
                        return message.getChannel()
                                .flatMap(channel -> channel.createMessage("world!"));
                    }

                    return Mono.empty();

                })).block();
    }
}
