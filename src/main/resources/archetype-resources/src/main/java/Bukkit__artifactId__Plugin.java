#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.command.ExampleCommand;
import ${package}.service.ExampleService;
import com.publicuhc.pluginframework.FrameworkJavaPlugin;
import com.publicuhc.pluginframework.commands.exceptions.CommandClassParseException;
import com.publicuhc.pluginframework.shaded.inject.AbstractModule;
import com.publicuhc.pluginframework.shaded.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Bukkit${artifactId}Plugin extends FrameworkJavaPlugin
{
    public void onFrameworkEnable()
    {
        try {
            getRouter().registerCommands(ExampleCommand.class);
        } catch (CommandClassParseException ex) {
            ex.printStackTrace();
        }
    }

    @Inject
    public void setExampleService(ExampleService object) {
        //before onFrameworkEnable this method will be called with an ExampleService which we can use here
        getLogger().log(Level.INFO, object.getExampleValue());
    }

    @Override
    public List<AbstractModule> initialModules() {
        List<AbstractModule> modules = new ArrayList<AbstractModule>();
        modules.add(new ${artifactId}Module());
        return modules;
    }
}
