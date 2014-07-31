#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.command;

import ${package}.service.ExampleService;
import com.publicuhc.pluginframework.commands.annotation.CommandMethod;
import com.publicuhc.pluginframework.commands.annotation.RouteInfo;
import com.publicuhc.pluginframework.commands.requests.CommandRequest;
import com.publicuhc.pluginframework.commands.requests.SenderType;
import com.publicuhc.pluginframework.commands.routes.RouteBuilder;
import com.publicuhc.pluginframework.configuration.Configurator;
import com.publicuhc.pluginframework.shaded.inject.Inject;
import com.publicuhc.pluginframework.translate.Translate;
import org.bukkit.ChatColor;

public class ExampleCommand
{
    private final Translate translator;
    private final Configurator configurator;
    private final ExampleService service;

    @Inject
    protected ExampleCommand(Translate translate, Configurator configurator, ExampleService service) {
        this.translator = translate;
        this.configurator = configurator;
        this.service = service;
    }

    @CommandMethod
    public void echoCommand(CommandRequest request) {
        StringBuilder builder = new StringBuilder();
        for(String s : request.getArgs()) {
            builder.append(s).append(" ");
        }
        request.sendMessage(builder.substring(0, builder.length()-1));
    }

    @RouteInfo
    public void echoCommand(RouteBuilder builder) {
        builder.restrictCommand("exampleecho");
    }

    @CommandMethod
    public void translate(CommandRequest request) {
        String firstArg = request.getFirstArg();
        if(null == firstArg) {
            request.sendMessage(ChatColor.RED + "Must supply a key");
            return;
        }
        request.sendMessage(translator.translate(firstArg, request.getLocale()));
    }

    @RouteInfo
    public void translate(RouteBuilder builder) {
        builder.restrictSenderType(SenderType.CONSOLE)
                .restrictCommand("exampletranslate");
    }

    @CommandMethod
    public void exampleConfig(CommandRequest request) {
        request.sendMessage(configurator.getConfig("exampleconfig").getString("exampleString"));
    }

    @RouteInfo
    public void exampleConfig(RouteBuilder builder) {
        builder.restrictArgumentCount(1, 1)
                .restrictCommand("exampleconfig");
    }

    @CommandMethod
    public void exampleService(CommandRequest request) {
        request.sendMessage(service.getExampleValue());
    }

    @RouteInfo
    public void exampleService(RouteBuilder builder) {
        builder.restrictCommand("exampleservice");
    }
}
