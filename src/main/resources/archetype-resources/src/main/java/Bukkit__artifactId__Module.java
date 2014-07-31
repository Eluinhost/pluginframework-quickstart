#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.service.DefaultExampleService;
import ${package}.service.ExampleService;
import com.publicuhc.pluginframework.shaded.inject.AbstractModule;

public class Bukkit${artifactId}Module extends AbstractModule
{
    @Override
    protected void configure() {
        //whenever we request an object of type ExampleService we will send an DefaultExampleService implementation
        bind(ExampleService.class).to(DefaultExampleService.class);
    }
}
